package org.finos.waltz.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.WaltzEntity;
import org.finos.waltz.model.tag.ImmutableTagUsage.Builder;
import org.finos.waltz.model.tag.ImmutableTagUsage.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTagUsageDiffblueTest {
  /**
   * Test {@link ImmutableTagUsage#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableTagUsage#builder()}
   *   <li>{@link ImmutableTagUsage#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableTagUsage#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableTagUsage Builder.build()", "Builder Builder.createdAt(LocalDateTime)",
      "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableTagUsage.builder();
    Builder actualCreatedAtResult = actualBuilderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualCreatedAtResult, actualCreatedAtResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   * <p>
   * Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName("Test Builder createdBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_givenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
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
    Builder builderResult = ImmutableTagUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TagUsage)} with {@code TagUsage}.
   * <ul>
   *   <li>Then builder build createdBy is {@code Jan 1, 2020 8:00am GMT+0100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TagUsage)}
   */
  @Test
  @DisplayName("Test Builder from(TagUsage) with 'TagUsage'; then builder build createdBy is 'Jan 1, 2020 8:00am GMT+0100'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TagUsage)"})
  void testBuilderFromWithTagUsage_thenBuilderBuildCreatedByIsJan12020800amGmt0100() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();
    TagUsage instance = mock(TagUsage.class);
    when(instance.tagId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).tagId();
    ImmutableTagUsage buildResult = builderResult.build();
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.tagId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TagUsage)} with {@code TagUsage}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TagUsage)}
   */
  @Test
  @DisplayName("Test Builder from(TagUsage) with 'TagUsage'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TagUsage)"})
  void testBuilderFromWithTagUsage_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();
    TagUsage instance = mock(TagUsage.class);
    when(instance.tagId()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).provenance();
    verify(instance).tagId();
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; given EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_givenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Test Builder {@link Builder#tagId(long)}.
   * <p>
   * Method under test: {@link Builder#tagId(long)}
   */
  @Test
  @DisplayName("Test Builder tagId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.tagId(long)"})
  void testBuilderTagId() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tagId(1L));
  }

  /**
   * Test Json {@link Json#createdAt()}.
   * <p>
   * Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdAt());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   * <p>
   * Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdBy());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link Json#setCreatedBy(String)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCreatedAt(LocalDateTime)", "void Json.setCreatedBy(String)",
      "void Json.setEntityReference(EntityReference)", "void Json.setProvenance(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    actualJson.setEntityReference(null);
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
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

  /**
   * Test Json {@link Json#setTagId(long)}.
   * <p>
   * Method under test: {@link Json#setTagId(long)}
   */
  @Test
  @DisplayName("Test Json setTagId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setTagId(long)"})
  void testJsonSetTagId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTagId(1L);

    // Assert
    assertEquals(1L, json.tagId);
    assertTrue(json.tagIdIsSet);
  }

  /**
   * Test Json {@link Json#tagId()}.
   * <p>
   * Method under test: {@link Json#tagId()}
   */
  @Test
  @DisplayName("Test Json tagId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.tagId()"})
  void testJsonTagId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).tagId());
  }
}
