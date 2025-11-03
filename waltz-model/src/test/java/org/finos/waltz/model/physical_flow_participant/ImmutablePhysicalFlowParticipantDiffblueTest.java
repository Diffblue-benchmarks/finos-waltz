package org.finos.waltz.model.physical_flow_participant;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.physical_flow_participant.ImmutablePhysicalFlowParticipant.Builder;
import org.finos.waltz.model.physical_flow_participant.ImmutablePhysicalFlowParticipant.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowParticipantDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalFlowParticipant#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParticipant#builder()}
   *   <li>{@link ImmutablePhysicalFlowParticipant#description(String)}
   *   <li>{@link ImmutablePhysicalFlowParticipant#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutablePhysicalFlowParticipant#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalFlowParticipant Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult = ImmutablePhysicalFlowParticipant.builder()
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
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
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
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
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
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
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
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParticipant)} with {@code PhysicalFlowParticipant}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParticipant)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParticipant) with 'PhysicalFlowParticipant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParticipant)"})
  void testBuilderFromWithPhysicalFlowParticipant() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    PhysicalFlowParticipant instance = mock(PhysicalFlowParticipant.class);
    when(instance.physicalFlowId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(ParticipationKind.SOURCE);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).physicalFlowId();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParticipant)} with {@code PhysicalFlowParticipant}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParticipant)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParticipant) with 'PhysicalFlowParticipant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParticipant)"})
  void testBuilderFromWithPhysicalFlowParticipant2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    PhysicalFlowParticipant instance = mock(PhysicalFlowParticipant.class);
    when(instance.physicalFlowId()).thenReturn(1L);
    when(instance.participant()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(ParticipationKind.SOURCE);
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
    verify(instance).kind();
    verify(instance).participant();
    verify(instance).physicalFlowId();
    ImmutablePhysicalFlowParticipant buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.physicalFlowId());
    assertEquals(ParticipationKind.SOURCE, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParticipant)} with {@code PhysicalFlowParticipant}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParticipant)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParticipant) with 'PhysicalFlowParticipant'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParticipant)"})
  void testBuilderFromWithPhysicalFlowParticipant_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    PhysicalFlowParticipant instance = mock(PhysicalFlowParticipant.class);
    when(instance.physicalFlowId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(ParticipationKind.SOURCE);
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
    verify(instance).kind();
    verify(instance).physicalFlowId();
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
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#kind(ParticipationKind)}.
   * <p>
   * Method under test: {@link Builder#kind(ParticipationKind)}
   */
  @Test
  @DisplayName("Test Builder kind(ParticipationKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(ParticipationKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(ParticipationKind.SOURCE));
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
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#participant(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#participant(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder participant(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.participant(EntityReference)"})
  void testBuilderParticipant_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.participant(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#physicalFlowId(long)}.
   * <p>
   * Method under test: {@link Builder#physicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Builder physicalFlowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.physicalFlowId(long)"})
  void testBuilderPhysicalFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalFlowId(1L));
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
   *   <li>{@link Json#setKind(ParticipationKind)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setParticipant(EntityReference)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setKind(ParticipationKind)",
      "void Json.setLastUpdatedAt(LocalDateTime)", "void Json.setLastUpdatedBy(String)",
      "void Json.setParticipant(EntityReference)", "void Json.setProvenance(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(ParticipationKind.SOURCE);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setParticipant(null);
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParticipationKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
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
   * Test Json {@link Json#participant()}.
   * <p>
   * Method under test: {@link Json#participant()}
   */
  @Test
  @DisplayName("Test Json participant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.participant()"})
  void testJsonParticipant() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).participant());
  }

  /**
   * Test Json {@link Json#physicalFlowId()}.
   * <p>
   * Method under test: {@link Json#physicalFlowId()}
   */
  @Test
  @DisplayName("Test Json physicalFlowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.physicalFlowId()"})
  void testJsonPhysicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalFlowId());
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
   * Test Json {@link Json#setPhysicalFlowId(long)}.
   * <p>
   * Method under test: {@link Json#setPhysicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Json setPhysicalFlowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPhysicalFlowId(long)"})
  void testJsonSetPhysicalFlowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPhysicalFlowId(1L);

    // Assert
    assertEquals(1L, json.physicalFlowId);
    assertTrue(json.physicalFlowIdIsSet);
  }
}
