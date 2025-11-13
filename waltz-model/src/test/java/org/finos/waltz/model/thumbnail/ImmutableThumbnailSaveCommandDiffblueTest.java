package org.finos.waltz.model.thumbnail;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.thumbnail.ImmutableThumbnailSaveCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableThumbnailSaveCommandDiffblueTest {
  /**
   * Test {@link ImmutableThumbnailSaveCommand#blob()}.
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#blob()}
   */
  @Test
  @DisplayName("Test blob()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ImmutableThumbnailSaveCommand.blob()"})
  void testBlob() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .blob());
  }

  /**
   * Test Builder {@link Builder#blob(byte[])}.
   *
   * <p>Method under test: {@link Builder#blob(byte[])}
   */
  @Test
  @DisplayName("Test Builder blob(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.blob(byte[])"})
  void testBuilderBlob() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act
    Builder actualBlobResult = builderResult.blob("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertSame(builderResult, actualBlobResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand Builder.build()",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() throws UnsupportedEncodingException {
    // Arrange
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualMimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableEntityReference parentEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableThumbnailSaveCommand actualImmutableThumbnailSaveCommand =
        actualMimeTypeResult.parentEntityReference(parentEntityReference).build();

    // Assert
    assertEquals("2020-03-01", actualImmutableThumbnailSaveCommand.lastUpdatedBy());
    assertEquals("text/plain", actualImmutableThumbnailSaveCommand.mimeType());
    assertSame(lastUpdatedAt, actualImmutableThumbnailSaveCommand.lastUpdatedAt());
    assertSame(parentEntityReference, actualImmutableThumbnailSaveCommand.parentEntityReference());
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand instance =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableThumbnailSaveCommand actualImmutableThumbnailSaveCommand =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableThumbnailSaveCommand);
    ImmutableThumbnailSaveCommand actualImmutableThumbnailSaveCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableThumbnailSaveCommand2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Builder#from(ThumbnailSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ThumbnailSaveCommand) with 'ThumbnailSaveCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ThumbnailSaveCommand)"})
  void testBuilderFromWithThumbnailSaveCommand() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand instance =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableThumbnailSaveCommand actualImmutableThumbnailSaveCommand = builderResult.build();
    assertEquals(instance, actualImmutableThumbnailSaveCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#mimeType(String)}.
   *
   * <ul>
   *   <li>When {@code text/plain}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#mimeType(String)}
   */
  @Test
  @DisplayName("Test Builder mimeType(String); when 'text/plain'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.mimeType(String)"})
  void testBuilderMimeType_whenTextPlain_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act
    Builder actualMimeTypeResult = builderResult.mimeType("text/plain");

    // Assert
    assertSame(builderResult, actualMimeTypeResult);
  }

  /**
   * Test Builder {@link Builder#parentEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentEntityReference(EntityReference)"})
  void testBuilderParentEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableThumbnailSaveCommand.builder();

    // Act
    Builder actualParentEntityReferenceResult =
        builderResult.parentEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualParentEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#copyOf(ThumbnailSaveCommand)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#copyOf(ThumbnailSaveCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ThumbnailSaveCommand); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand ImmutableThumbnailSaveCommand.copyOf(ThumbnailSaveCommand)"
  })
  void testCopyOf_thenParentEntityReferenceReturnImmutableEntityReference()
      throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand instance =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableThumbnailSaveCommand actualCopyOfResult =
        ImmutableThumbnailSaveCommand.copyOf(instance);

    // Assert
    EntityReference parentEntityReferenceResult = actualCopyOfResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("text/plain", actualCopyOfResult.mimeType());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}, and {@link
   * ImmutableThumbnailSaveCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableThumbnailSaveCommand#equals(Object)}
   *   <li>{@link ImmutableThumbnailSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand2 =
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableThumbnailSaveCommand, immutableThumbnailSaveCommand2);
    assertEquals(
        immutableThumbnailSaveCommand.hashCode(), immutableThumbnailSaveCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}, and {@link
   * ImmutableThumbnailSaveCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableThumbnailSaveCommand#equals(Object)}
   *   <li>{@link ImmutableThumbnailSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableThumbnailSaveCommand, immutableThumbnailSaveCommand);
    int expectedHashCodeResult = immutableThumbnailSaveCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableThumbnailSaveCommand.hashCode());
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Builder lastUpdatedAtResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob(
                (byte) 1,
                (byte) 'X',
                (byte) 'A',
                (byte) 'X',
                (byte) 'A',
                (byte) 'X',
                (byte) 'A',
                (byte) 'X')
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    Builder mimeTypeResult = lastUpdatedAtResult.lastUpdatedBy("2020-03-01").mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnailSaveCommand,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnailSaveCommand,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnailSaveCommand,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/html");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnailSaveCommand,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnailSaveCommand,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnailSaveCommand.equals(Object)",
    "int ImmutableThumbnailSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableThumbnailSaveCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableThumbnailSaveCommand#toString()}
   *   <li>{@link ImmutableThumbnailSaveCommand#lastUpdatedAt()}
   *   <li>{@link ImmutableThumbnailSaveCommand#lastUpdatedBy()}
   *   <li>{@link ImmutableThumbnailSaveCommand#mimeType()}
   *   <li>{@link ImmutableThumbnailSaveCommand#parentEntityReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDateTime ImmutableThumbnailSaveCommand.lastUpdatedAt()",
    "String ImmutableThumbnailSaveCommand.lastUpdatedBy()",
    "String ImmutableThumbnailSaveCommand.mimeType()",
    "EntityReference ImmutableThumbnailSaveCommand.parentEntityReference()",
    "String ImmutableThumbnailSaveCommand.toString()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableThumbnailSaveCommand.toString();
    LocalDateTime actualLastUpdatedAtResult = immutableThumbnailSaveCommand.lastUpdatedAt();
    String actualLastUpdatedByResult = immutableThumbnailSaveCommand.lastUpdatedBy();
    String actualMimeTypeResult = immutableThumbnailSaveCommand.mimeType();

    // Assert
    assertTrue(
        immutableThumbnailSaveCommand.parentEntityReference() instanceof ImmutableEntityReference);
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals(
        "ThumbnailSaveCommand{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, parentEntityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, mimeType=text/plain, blob=[65, 88, 65,"
            + " 88, 65, 88, 65, 88]}",
        actualToStringResult);
    assertEquals("text/plain", actualMimeTypeResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#withBlob(byte[])}.
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#withBlob(byte[])}
   */
  @Test
  @DisplayName("Test withBlob(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand ImmutableThumbnailSaveCommand.withBlob(byte[])"
  })
  void testWithBlob() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableThumbnailSaveCommand actualWithBlobResult =
        immutableThumbnailSaveCommand.withBlob(
            (byte) 'A',
            (byte) 'X',
            (byte) 'A',
            (byte) 'X',
            (byte) 'A',
            (byte) 'X',
            (byte) 'A',
            (byte) 'X');

    // Assert
    assertEquals(immutableThumbnailSaveCommand, actualWithBlobResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand ImmutableThumbnailSaveCommand.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableThumbnailSaveCommand actualWithLastUpdatedAtResult =
        immutableThumbnailSaveCommand.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableThumbnailSaveCommand, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand ImmutableThumbnailSaveCommand.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableThumbnailSaveCommand actualWithLastUpdatedByResult =
        immutableThumbnailSaveCommand.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableThumbnailSaveCommand, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand ImmutableThumbnailSaveCommand.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenParentEntityReferenceReturnImmutableEntityReference()
      throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    ImmutableThumbnailSaveCommand actualWithLastUpdatedByResult =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference parentEntityReferenceResult =
        actualWithLastUpdatedByResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("text/plain", actualWithLastUpdatedByResult.mimeType());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#withMimeType(String)}.
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#withMimeType(String)}
   */
  @Test
  @DisplayName("Test withMimeType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand ImmutableThumbnailSaveCommand.withMimeType(String)"
  })
  void testWithMimeType() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("42");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableThumbnailSaveCommand actualWithMimeTypeResult =
        immutableThumbnailSaveCommand.withMimeType("42");

    // Assert
    assertSame(immutableThumbnailSaveCommand, actualWithMimeTypeResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#withMimeType(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnailSaveCommand#withMimeType(String)}
   */
  @Test
  @DisplayName(
      "Test withMimeType(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand ImmutableThumbnailSaveCommand.withMimeType(String)"
  })
  void testWithMimeType_thenParentEntityReferenceReturnImmutableEntityReference()
      throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    ImmutableThumbnailSaveCommand actualWithMimeTypeResult =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withMimeType("42");

    // Assert
    EntityReference parentEntityReferenceResult = actualWithMimeTypeResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithMimeTypeResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithMimeTypeResult.lastUpdatedBy());
    assertEquals("42", actualWithMimeTypeResult.mimeType());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnailSaveCommand#withParentEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableThumbnailSaveCommand#withParentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnailSaveCommand ImmutableThumbnailSaveCommand.withParentEntityReference(EntityReference)"
  })
  void testWithParentEntityReference() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnailSaveCommand immutableThumbnailSaveCommand =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableThumbnailSaveCommand actualWithParentEntityReferenceResult =
        immutableThumbnailSaveCommand.withParentEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableThumbnailSaveCommand, actualWithParentEntityReferenceResult);
  }
}
