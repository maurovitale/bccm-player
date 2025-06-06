// Autogenerated from Pigeon (v22.7.4), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package media.bcc.bccm_player.pigeon;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression", "serial"})
public class ChromecastControllerPigeon {

  /** Error class for passing custom error details to Flutter via a thrown PlatformException. */
  public static class FlutterError extends RuntimeException {

    /** The error code. */
    public final String code;

    /** The error details. Must be a datatype supported by the api codec. */
    public final Object details;

    public FlutterError(@NonNull String code, @Nullable String message, @Nullable Object details) 
    {
      super(message);
      this.code = code;
      this.details = details;
    }
  }

  @NonNull
  protected static FlutterError createConnectionError(@NonNull String channelName) {
    return new FlutterError("channel-error",  "Unable to establish connection on channel: " + channelName + ".", "");
  }

  @Target(METHOD)
  @Retention(CLASS)
  @interface CanIgnoreReturnValue {}

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class CastSessionUnavailableEvent {
    private @Nullable Long playbackPositionMs;

    public @Nullable Long getPlaybackPositionMs() {
      return playbackPositionMs;
    }

    public void setPlaybackPositionMs(@Nullable Long setterArg) {
      this.playbackPositionMs = setterArg;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) { return true; }
      if (o == null || getClass() != o.getClass()) { return false; }
      CastSessionUnavailableEvent that = (CastSessionUnavailableEvent) o;
      return Objects.equals(playbackPositionMs, that.playbackPositionMs);
    }

    @Override
    public int hashCode() {
      return Objects.hash(playbackPositionMs);
    }

    public static final class Builder {

      private @Nullable Long playbackPositionMs;

      @CanIgnoreReturnValue
      public @NonNull Builder setPlaybackPositionMs(@Nullable Long setterArg) {
        this.playbackPositionMs = setterArg;
        return this;
      }

      public @NonNull CastSessionUnavailableEvent build() {
        CastSessionUnavailableEvent pigeonReturn = new CastSessionUnavailableEvent();
        pigeonReturn.setPlaybackPositionMs(playbackPositionMs);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<>(1);
      toListResult.add(playbackPositionMs);
      return toListResult;
    }

    static @NonNull CastSessionUnavailableEvent fromList(@NonNull ArrayList<Object> pigeonVar_list) {
      CastSessionUnavailableEvent pigeonResult = new CastSessionUnavailableEvent();
      Object playbackPositionMs = pigeonVar_list.get(0);
      pigeonResult.setPlaybackPositionMs((Long) playbackPositionMs);
      return pigeonResult;
    }
  }

  private static class PigeonCodec extends StandardMessageCodec {
    public static final PigeonCodec INSTANCE = new PigeonCodec();

    private PigeonCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 129:
          return CastSessionUnavailableEvent.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof CastSessionUnavailableEvent) {
        stream.write(129);
        writeValue(stream, ((CastSessionUnavailableEvent) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }


  /** Asynchronous error handling return type for non-nullable API method returns. */
  public interface Result<T> {
    /** Success case callback method for handling returns. */
    void success(@NonNull T result);

    /** Failure case callback method for handling errors. */
    void error(@NonNull Throwable error);
  }
  /** Asynchronous error handling return type for nullable API method returns. */
  public interface NullableResult<T> {
    /** Success case callback method for handling returns. */
    void success(@Nullable T result);

    /** Failure case callback method for handling errors. */
    void error(@NonNull Throwable error);
  }
  /** Asynchronous error handling return type for void API method returns. */
  public interface VoidResult {
    /** Success case callback method for handling returns. */
    void success();

    /** Failure case callback method for handling errors. */
    void error(@NonNull Throwable error);
  }
  /**
   * An API called by the native side to notify about chromecast changes
   *
   * Generated class from Pigeon that represents Flutter messages that can be called from Java.
   */
  public static class ChromecastPigeon {
    private final @NonNull BinaryMessenger binaryMessenger;
    private final String messageChannelSuffix;

    public ChromecastPigeon(@NonNull BinaryMessenger argBinaryMessenger) {
      this(argBinaryMessenger, "");
    }
    public ChromecastPigeon(@NonNull BinaryMessenger argBinaryMessenger, @NonNull String messageChannelSuffix) {
      this.binaryMessenger = argBinaryMessenger;
      this.messageChannelSuffix = messageChannelSuffix.isEmpty() ? "" : "." + messageChannelSuffix;
    }

    /**
     * Public interface for sending reply.
     * The codec used by ChromecastPigeon.
     */
    static @NonNull MessageCodec<Object> getCodec() {
      return PigeonCodec.INSTANCE;
    }
    public void onSessionEnded(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionEnded" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onSessionEnding(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionEnding" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onSessionResumeFailed(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionResumeFailed" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onSessionResumed(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionResumed" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onSessionResuming(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionResuming" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onSessionStartFailed(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionStartFailed" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onSessionStarted(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionStarted" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onSessionStarting(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionStarting" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onSessionSuspended(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onSessionSuspended" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onCastSessionAvailable(@NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onCastSessionAvailable" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          null,
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onCastSessionUnavailable(@NonNull CastSessionUnavailableEvent eventArg, @NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.bccm_player.ChromecastPigeon.onCastSessionUnavailable" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          new ArrayList<>(Collections.singletonList(eventArg)),
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
  }
}
