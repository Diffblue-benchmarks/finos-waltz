package org.finos.waltz.model.thumbnail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.thumbnail.ImmutableThumbnail.Builder;
import org.finos.waltz.model.thumbnail.ImmutableThumbnail.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableThumbnailDiffblueTest {
  /**
   * Test {@link ImmutableThumbnail#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableThumbnail#builder()}
   *   <li>{@link ImmutableThumbnail#externalId(String)}
   *   <li>{@link ImmutableThumbnail#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableThumbnail#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableThumbnail Builder.build()", "Builder Builder.externalId(String)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableThumbnail.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    Builder actualLastUpdatedAtResult = actualExternalIdResult2.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
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
    Builder builderResult = ImmutableThumbnail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.blob("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableThumbnail.builder();
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
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Thumbnail)} with {@code Thumbnail}.
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Thumbnail)}
   */
  @Test
  @DisplayName("Test Builder from(Thumbnail) with 'Thumbnail'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Thumbnail)"})
  void testBuilderFromWithThumbnail_thenBuilderBuildLastUpdatedByIs20200301() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();
    Thumbnail instance = mock(Thumbnail.class);
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
    ImmutableThumbnail buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Mime Type", buildResult.mimeType());
    assertEquals("Provenance", buildResult.provenance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Thumbnail)} with {@code Thumbnail}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Thumbnail)}
   */
  @Test
  @DisplayName("Test Builder from(Thumbnail) with 'Thumbnail'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Thumbnail)"})
  void testBuilderFromWithThumbnail_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();
    Thumbnail instance = mock(Thumbnail.class);
    when(instance.parentEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
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
    Builder builderResult = ImmutableThumbnail.builder();

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
    Builder builderResult = ImmutableThumbnail.builder();

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
    Builder builderResult = ImmutableThumbnail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityReference(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#blob()}.
   * <p>
   * Method under test: {@link Json#blob()}
   */
  @Test
  @DisplayName("Test Json blob()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] Json.blob()"})
  void testJsonBlob() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).blob());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#mimeType()}.
   * <p>
   * Method under test: {@link Json#mimeType()}
   */
  @Test
  @DisplayName("Test Json mimeType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.mimeType()"})
  void testJsonMimeType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).mimeType());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.blob);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.mimeType);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.parentEntityReference);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Test Json {@link Json#parentEntityReference()}.
   * <p>
   * Method under test: {@link Json#parentEntityReference()}
   */
  @Test
  @DisplayName("Test Json parentEntityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.parentEntityReference()"})
  void testJsonParentEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentEntityReference());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }
}
