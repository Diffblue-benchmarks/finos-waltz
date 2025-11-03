package org.finos.waltz.model.thumbnail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.thumbnail.ImmutableThumbnailSaveCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableThumbnailSaveCommandDiffblueTest {
  /**
   * Test {@link ImmutableThumbnailSaveCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableThumbnailSaveCommand#builder()}
   *   <li>{@link ImmutableThumbnailSaveCommand#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableThumbnailSaveCommand Builder.build()", "Builder Builder.lastUpdatedAt(LocalDateTime)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableThumbnailSaveCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#blob(byte[])}.
   * <p>
   * Method under test: {@link Builder#blob(byte[])}
   */
  @Test
  @DisplayName("Test Builder blob(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.blob(byte[])"})
  void testBuilderBlob() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.blob("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ThumbnailSaveCommand)} with {@code ThumbnailSaveCommand}.
   * <p>
   * Method under test: {@link Builder#from(ThumbnailSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ThumbnailSaveCommand) with 'ThumbnailSaveCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ThumbnailSaveCommand)"})
  void testBuilderFromWithThumbnailSaveCommand() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();
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
   * Test Builder {@link Builder#from(ThumbnailSaveCommand)} with {@code ThumbnailSaveCommand}.
   * <p>
   * Method under test: {@link Builder#from(ThumbnailSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ThumbnailSaveCommand) with 'ThumbnailSaveCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ThumbnailSaveCommand)"})
  void testBuilderFromWithThumbnailSaveCommand2() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();
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
   * Test Builder {@link Builder#from(ThumbnailSaveCommand)} with {@code ThumbnailSaveCommand}.
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ThumbnailSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ThumbnailSaveCommand) with 'ThumbnailSaveCommand'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ThumbnailSaveCommand)"})
  void testBuilderFromWithThumbnailSaveCommand_thenBuilderBuildLastUpdatedByIs20200301()
      throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();
    ThumbnailSaveCommand instance = mock(ThumbnailSaveCommand.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#mimeType(String)}.
   * <p>
   * Method under test: {@link Builder#mimeType(String)}
   */
  @Test
  @DisplayName("Test Builder mimeType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.mimeType(String)"})
  void testBuilderMimeType() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.mimeType("Mime Type"));
  }

  /**
   * Test Builder {@link Builder#parentEntityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentEntityReference(EntityReference)"})
  void testBuilderParentEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityReference(mock(EntityReference.class)));
  }
}
