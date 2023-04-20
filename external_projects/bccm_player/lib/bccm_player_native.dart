import 'package:bccm_player/src/pigeon/chromecast_pigeon.g.dart';
import 'package:bccm_player/src/native/root_pigeon_playback_listener.dart';
import 'package:bccm_player/src/native/chromecast_pigeon_listener.dart';
import 'package:bccm_player/src/pigeon/playback_platform_pigeon.g.dart';
import 'package:bccm_player/src/playback_platform_interface.dart';

/// An implementation of [BccmPlayerPlatform] that uses pigeon.
class BccmPlayerNative extends BccmPlayerInterface {
  final PlaybackPlatformPigeon _pigeon = PlaybackPlatformPigeon();
  final RootPigeonPlaybackListener _rootPlaybackListener = RootPigeonPlaybackListener();
  final ChromecastPigeonListener _chromecastListener = ChromecastPigeonListener();

  BccmPlayerNative() {
    ChromecastPigeon.setup(_chromecastListener);
    PlaybackListenerPigeon.setup(_rootPlaybackListener);
  }

  @override
  chromecastEventStream() => _chromecastListener.stream();

  @override
  Future<String> newPlayer({String? url}) async {
    final playerId = await _pigeon.newPlayer(url);
    stateNotifier.addPlayerNotifier(playerId);
    return playerId;
  }

  @override
  Future<bool> setPrimary(String id) async {
    await _pigeon.setPrimary(id);
    stateNotifier.setPrimaryPlayer(id);
    return true;
  }

  @override
  Future<void> replaceCurrentMediaItem(String playerId, MediaItem mediaItem, {bool? playbackPositionFromPrimary, bool? autoplay = true}) async {
    await _pigeon.replaceCurrentMediaItem(playerId, mediaItem, playbackPositionFromPrimary, autoplay);
  }

  @override
  Future<void> queueMediaItem(String playerId, MediaItem mediaItem) {
    return _pigeon.queueMediaItem(playerId, mediaItem);
  }

  @override
  Future<ChromecastState?> getChromecastState() {
    return _pigeon.getChromecastState();
  }

  @override
  void openExpandedCastController() {
    _pigeon.openExpandedCastController();
  }

  @override
  void openCastDialog() {
    _pigeon.openCastDialog();
  }

  @override
  Future<void> addPlaybackListener(PlaybackListenerPigeon listener) async {
    _rootPlaybackListener.addListener(listener);
  }

  @override
  void play(String playerId) {
    _pigeon.play(playerId);
  }

  @override
  void pause(String playerId) {
    _pigeon.pause(playerId);
  }

  @override
  void stop(String playerId, bool reset) {
    _pigeon.stop(playerId, reset);
  }

  @override
  Future setNpawConfig(NpawConfig? config) {
    return _pigeon.setNpawConfig(config);
  }

  @override
  void setAppConfig(AppConfig? config) {
    _pigeon.setAppConfig(config);
  }

  @override
  void setPlayerViewVisibility(int viewId, bool visible) {
    _pigeon.setPlayerViewVisibility(viewId, visible);
  }
}