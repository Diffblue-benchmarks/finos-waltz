package org.finos.waltz.model.thumbnail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.junit.jupiter.api.Test;

class ImmutableThumbnailSaveCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableThumbnailSaveCommand#builder()}
   *   <li>{@link ImmutableThumbnailSaveCommand#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableThumbnailSaveCommand.Builder actualBuilderResult = ImmutableThumbnailSaveCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableThumbnailSaveCommand.Builder#blob(byte[])}
   */
  @Test
  void testBuilderBlob() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.blob("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableThumbnailSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#from(ThumbnailSaveCommand)}
   */
  @Test
  void testBuilderFrom4() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    ThumbnailSaveCommand instance = mock(ThumbnailSaveCommand.class);
    when(instance.parentEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#from(ThumbnailSaveCommand)}
   */
  @Test
  void testBuilderFrom5() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    ThumbnailSaveCommand instance = mock(ThumbnailSaveCommand.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableThumbnailSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
    ImmutableThumbnailSaveCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Mime Type", buildResult.mimeType());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#from(ThumbnailSaveCommand)}
   */
  @Test
  void testBuilderFrom6() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    ThumbnailSaveCommand instance = mock(ThumbnailSaveCommand.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#mimeType(String)}
   */
  @Test
  void testBuilderMimeType() {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.mimeType("Mime Type"));
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand.Builder#parentEntityReference(EntityReference)}
   */
  @Test
  void testBuilderParentEntityReference() {
    // Arrange
    ImmutableThumbnailSaveCommand.Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnailSaveCommand#copyOf(ThumbnailSaveCommand)}
   */
  @Test
  void testCopyOf() throws UnsupportedEncodingException {
    // Arrange
    ThumbnailSaveCommand instance = mock(ThumbnailSaveCommand.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableThumbnailSaveCommand actualCopyOfResult = ImmutableThumbnailSaveCommand.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Mime Type", actualCopyOfResult.mimeType());
    assertSame(ofResult, toLocalDateResult);
  }
}
