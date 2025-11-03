package org.finos.waltz.model.measurable_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.measurable_relationship.ImmutableMeasurableRelationship.Builder;
import org.finos.waltz.model.measurable_relationship.ImmutableMeasurableRelationship.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRelationshipDiffblueTest {
  /**
   * Test {@link ImmutableMeasurableRelationship#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRelationship#builder()}
   *   <li>{@link ImmutableMeasurableRelationship#description(String)}
   *   <li>{@link ImmutableMeasurableRelationship#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableRelationship#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRelationship Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult = ImmutableMeasurableRelationship.builder()
        .description("The characteristics of someone or something");
    Builder actualLastUpdatedAtResult = actualDescriptionResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableMeasurableRelationship.builder();
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
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRelationship)} with {@code MeasurableRelationship}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRelationship) with 'MeasurableRelationship'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRelationship)"})
  void testBuilderFromWithMeasurableRelationship() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    MeasurableRelationship instance = mock(MeasurableRelationship.class);
    when(instance.measurableA()).thenReturn(1L);
    when(instance.relationshipKind()).thenReturn(MeasurableRelationshipKind.WEAKLY_RELATES_TO);
    when(instance.measurableB()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableA();
    verify(instance).measurableB();
    verify(instance).relationshipKind();
    ImmutableMeasurableRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.measurableA());
    assertEquals(1L, buildResult.measurableB());
    assertEquals(MeasurableRelationshipKind.WEAKLY_RELATES_TO, buildResult.relationshipKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRelationship)} with {@code MeasurableRelationship}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRelationship) with 'MeasurableRelationship'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRelationship)"})
  void testBuilderFromWithMeasurableRelationship_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    MeasurableRelationship instance = mock(MeasurableRelationship.class);
    when(instance.measurableA()).thenReturn(1L);
    when(instance.relationshipKind()).thenReturn(MeasurableRelationshipKind.WEAKLY_RELATES_TO);
    when(instance.measurableB()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableA();
    verify(instance).measurableB();
    verify(instance).relationshipKind();
    ImmutableMeasurableRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.measurableA());
    assertEquals(1L, buildResult.measurableB());
    assertEquals(MeasurableRelationshipKind.WEAKLY_RELATES_TO, buildResult.relationshipKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRelationship)} with {@code MeasurableRelationship}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRelationship) with 'MeasurableRelationship'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRelationship)"})
  void testBuilderFromWithMeasurableRelationship_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    MeasurableRelationship instance = mock(MeasurableRelationship.class);
    when(instance.measurableA()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableB()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableA();
    verify(instance).measurableB();
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
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
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
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#measurableA(long)}.
   * <p>
   * Method under test: {@link Builder#measurableA(long)}
   */
  @Test
  @DisplayName("Test Builder measurableA(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableA(long)"})
  void testBuilderMeasurableA() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableA(1L));
  }

  /**
   * Test Builder {@link Builder#measurableB(long)}.
   * <p>
   * Method under test: {@link Builder#measurableB(long)}
   */
  @Test
  @DisplayName("Test Builder measurableB(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableB(long)"})
  void testBuilderMeasurableB() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableB(1L));
  }

  /**
   * Test Builder {@link Builder#relationshipKind(MeasurableRelationshipKind)}.
   * <p>
   * Method under test: {@link Builder#relationshipKind(MeasurableRelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder relationshipKind(MeasurableRelationshipKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relationshipKind(MeasurableRelationshipKind)"})
  void testBuilderRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO));
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setProvenance(String)}
   *   <li>{@link Json#setRelationshipKind(MeasurableRelationshipKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)",
      "void Json.setLastUpdatedAt(LocalDateTime)", "void Json.setLastUpdatedBy(String)",
      "void Json.setProvenance(String)", "void Json.setRelationshipKind(MeasurableRelationshipKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");
    actualJson.setRelationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO);

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
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
   * Test Json {@link Json#measurableA()}.
   * <p>
   * Method under test: {@link Json#measurableA()}
   */
  @Test
  @DisplayName("Test Json measurableA()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.measurableA()"})
  void testJsonMeasurableA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableA());
  }

  /**
   * Test Json {@link Json#measurableB()}.
   * <p>
   * Method under test: {@link Json#measurableB()}
   */
  @Test
  @DisplayName("Test Json measurableB()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.measurableB()"})
  void testJsonMeasurableB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableB());
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
   * Test Json {@link Json#relationshipKind()}.
   * <p>
   * Method under test: {@link Json#relationshipKind()}
   */
  @Test
  @DisplayName("Test Json relationshipKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableRelationshipKind Json.relationshipKind()"})
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relationshipKind());
  }

  /**
   * Test Json {@link Json#setMeasurableA(long)}.
   * <p>
   * Method under test: {@link Json#setMeasurableA(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableA(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setMeasurableA(long)"})
  void testJsonSetMeasurableA() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableA(1L);

    // Assert
    assertEquals(1L, json.measurableA);
    assertTrue(json.measurableAIsSet);
  }

  /**
   * Test Json {@link Json#setMeasurableB(long)}.
   * <p>
   * Method under test: {@link Json#setMeasurableB(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableB(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setMeasurableB(long)"})
  void testJsonSetMeasurableB() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableB(1L);

    // Assert
    assertEquals(1L, json.measurableB);
    assertTrue(json.measurableBIsSet);
  }
}
