// Autogenerated from Pigeon (v22.7.4), do not edit directly.
// See also: https://pub.dev/packages/pigeon

#import <Foundation/Foundation.h>

@protocol FlutterBinaryMessenger;
@protocol FlutterMessageCodec;
@class FlutterError;
@class FlutterStandardTypedData;

NS_ASSUME_NONNULL_BEGIN

@class CastSessionUnavailableEvent;

@interface CastSessionUnavailableEvent : NSObject
+ (instancetype)makeWithPlaybackPositionMs:(nullable NSNumber *)playbackPositionMs;
@property(nonatomic, strong, nullable) NSNumber * playbackPositionMs;
@end

/// The codec used by all APIs.
NSObject<FlutterMessageCodec> *nullGetChromecastPigeonCodec(void);

/// An API called by the native side to notify about chromecast changes
@interface ChromecastPigeon : NSObject
- (instancetype)initWithBinaryMessenger:(id<FlutterBinaryMessenger>)binaryMessenger;
- (instancetype)initWithBinaryMessenger:(id<FlutterBinaryMessenger>)binaryMessenger messageChannelSuffix:(nullable NSString *)messageChannelSuffix;
- (void)onSessionEnded:(void (^)(FlutterError *_Nullable))completion;
- (void)onSessionEnding:(void (^)(FlutterError *_Nullable))completion;
- (void)onSessionResumeFailed:(void (^)(FlutterError *_Nullable))completion;
- (void)onSessionResumed:(void (^)(FlutterError *_Nullable))completion;
- (void)onSessionResuming:(void (^)(FlutterError *_Nullable))completion;
- (void)onSessionStartFailed:(void (^)(FlutterError *_Nullable))completion;
- (void)onSessionStarted:(void (^)(FlutterError *_Nullable))completion;
- (void)onSessionStarting:(void (^)(FlutterError *_Nullable))completion;
- (void)onSessionSuspended:(void (^)(FlutterError *_Nullable))completion;
- (void)onCastSessionAvailable:(void (^)(FlutterError *_Nullable))completion;
- (void)onCastSessionUnavailable:(CastSessionUnavailableEvent *)event completion:(void (^)(FlutterError *_Nullable))completion;
@end

NS_ASSUME_NONNULL_END
