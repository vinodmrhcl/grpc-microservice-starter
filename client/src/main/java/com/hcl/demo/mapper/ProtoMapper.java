package com.hcl.demo.mapper;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.hcl.demo.proto.util.Date;

public class ProtoMapper {

	public static LocalDate dateProtoToLocalDate(Date date) {
		return date == null ? null : LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
	}

	public static Date localDateToDateProto(LocalDate date) {
		return date == null ? null : Date.newBuilder().setYear(date.getYear()).setMonth(date.getMonthValue()).setDay(date.getDayOfMonth()).build();
	}

	public static ZonedDateTime timestampToZonedDateTime(Timestamp timestamp) {
		return timestamp == null ? null : ZonedDateTime.ofInstant(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()), ZoneId.of("UTC"));
	}

	public static Timestamp zonedDateTimeToTimestamp(ZonedDateTime zonedDateTime) {
		return zonedDateTime == null ? null : instantToTimestamp(zonedDateTime.toInstant());
	}

	public static Timestamp instantToTimestamp(Instant instant) {
		return instant == null ? null : Timestamp.newBuilder().setSeconds(instant.getEpochSecond()).setNanos(instant.getNano()).build();
	}

	public static Timestamp dateToTimestamp(java.util.Date date) {
		return date == null ? null : instantToTimestamp(date.toInstant());
	}

	public static ByteString bytesToByteString(byte[] bytes) {
		return bytes == null ? null : ByteString.copyFrom(bytes);
	}

	public static byte[] ByteStringToBytes(ByteString byteString) {
		return byteString == null ? null : byteString.toByteArray();
	}

	public static ByteString byteBufferToByteString(ByteBuffer buffer) {
		return buffer == null ? null : ByteString.copyFrom(buffer);
	}

	public static ByteBuffer byteStringToByteBuffer(ByteString byteString) {
		return byteString == null ? null : byteString.asReadOnlyByteBuffer();
	}

	public static String uuidToString(UUID uuid) {
		return uuid == null ? null : uuid.toString();
	}

	public static UUID stringToUuid(String uuid) {
		return uuid == null || uuid.isEmpty() ? null : UUID.fromString(uuid);
	}

}
