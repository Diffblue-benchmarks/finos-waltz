package org.finos.waltz.model.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticValue.Builder;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticValue.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticValueDiffblueTest {
  /**
   * Test {@link ImmutableEntityStatisticValue#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityStatisticValue#builder()}
   *   <li>{@link ImmutableEntityStatisticValue#provenance(String)}
   *   <li>{@link ImmutableEntityStatisticValue#reason(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableEntityStatisticValue Builder.build()", "Builder Builder.provenance(String)",
      "Builder Builder.reason(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableEntityStatisticValue.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualProvenanceResult = actualIdResult.id(id).provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.reason("Just cause"));
  }

  /**
   * Test Builder {@link Builder#createdAt(LocalDateTime)}.
   * <p>
   * Method under test: {@link Builder#createdAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder createdAt(LocalDateTime)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.createdAt(LocalDateTime)"})
  void testBuilderCreatedAt() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#current(boolean)}.
   * <p>
   * Method under test: {@link Builder#current(boolean)}
   */
  @Test
  @DisplayName("Test Builder current(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.current(boolean)"})
  void testBuilderCurrent() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.current(true));
  }

  /**
   * Test Builder {@link Builder#entity(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entity(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entity(EntityReference)"})
  void testBuilderEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entity(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticValue)} with {@code EntityStatisticValue}.
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticValue) with 'EntityStatisticValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticValue)"})
  void testBuilderFromWithEntityStatisticValue() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.outcome()).thenThrow(new IllegalStateException("instance"));
    when(instance.entity()).thenReturn(mock(EntityReference.class));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).outcome();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticValue)} with {@code EntityStatisticValue}.
   * <ul>
   *   <li>Given {@code Outcome}.</li>
   *   <li>Then builder build value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticValue) with 'EntityStatisticValue'; given 'Outcome'; then builder build value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticValue)"})
  void testBuilderFromWithEntityStatisticValue_givenOutcome_thenBuilderBuildValueIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.outcome()).thenReturn("Outcome");
    when(instance.entity()).thenReturn(mock(EntityReference.class));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).outcome();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
    ImmutableEntityStatisticValue buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Just cause", buildResult.reason());
    assertEquals("Outcome", buildResult.outcome());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.statisticId());
    assertEquals(StatisticValueState.EXEMPT, buildResult.state());
    assertTrue(buildResult.current());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticValue)} with {@code EntityStatisticValue}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticValue) with 'EntityStatisticValue'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticValue)"})
  void testBuilderFromWithEntityStatisticValue_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.entity()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticValue)} with {@code EntityStatisticValue}.
   * <ul>
   *   <li>When {@link EntityStatisticValue} {@link EntityStatisticValue#reason()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticValue) with 'EntityStatisticValue'; when EntityStatisticValue reason() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticValue)"})
  void testBuilderFromWithEntityStatisticValue_whenEntityStatisticValueReasonReturnNull() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.entity()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn(null);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#outcome(String)}.
   * <p>
   * Method under test: {@link Builder#outcome(String)}
   */
  @Test
  @DisplayName("Test Builder outcome(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.outcome(String)"})
  void testBuilderOutcome() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.outcome("Outcome"));
  }

  /**
   * Test Builder {@link Builder#state(StatisticValueState)}.
   * <p>
   * Method under test: {@link Builder#state(StatisticValueState)}
   */
  @Test
  @DisplayName("Test Builder state(StatisticValueState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.state(StatisticValueState)"})
  void testBuilderState() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.state(StatisticValueState.EXEMPT));
  }

  /**
   * Test Builder {@link Builder#statisticId(long)}.
   * <p>
   * Method under test: {@link Builder#statisticId(long)}
   */
  @Test
  @DisplayName("Test Builder statisticId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.statisticId(long)"})
  void testBuilderStatisticId() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.statisticId(1L));
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   * <p>
   * Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
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
   * Test Json {@link Json#current()}.
   * <p>
   * Method under test: {@link Json#current()}
   */
  @Test
  @DisplayName("Test Json current()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.current()"})
  void testJsonCurrent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).current());
  }

  /**
   * Test Json {@link Json#entity()}.
   * <p>
   * Method under test: {@link Json#entity()}
   */
  @Test
  @DisplayName("Test Json entity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entity()"})
  void testJsonEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entity());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
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
    assertNull(actualJson.outcome);
    assertNull(actualJson.provenance);
    assertNull(actualJson.reason);
    assertNull(actualJson.value);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.entity);
    assertNull(actualJson.state);
    assertEquals(0L, actualJson.statisticId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.current);
    assertFalse(actualJson.currentIsSet);
    assertFalse(actualJson.statisticIdIsSet);
  }

  /**
   * Test Json {@link Json#outcome()}.
   * <p>
   * Method under test: {@link Json#outcome()}
   */
  @Test
  @DisplayName("Test Json outcome()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.outcome()"})
  void testJsonOutcome() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).outcome());
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
   * Test Json {@link Json#reason()}.
   * <p>
   * Method under test: {@link Json#reason()}
   */
  @Test
  @DisplayName("Test Json reason()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.reason()"})
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).reason());
  }

  /**
   * Test Json {@link Json#setCurrent(boolean)}.
   * <p>
   * Method under test: {@link Json#setCurrent(boolean)}
   */
  @Test
  @DisplayName("Test Json setCurrent(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCurrent(boolean)"})
  void testJsonSetCurrent() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCurrent(true);

    // Assert
    assertTrue(json.current);
    assertTrue(json.currentIsSet);
  }

  /**
   * Test Json {@link Json#setStatisticId(long)}.
   * <p>
   * Method under test: {@link Json#setStatisticId(long)}
   */
  @Test
  @DisplayName("Test Json setStatisticId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setStatisticId(long)"})
  void testJsonSetStatisticId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setStatisticId(1L);

    // Assert
    assertEquals(1L, json.statisticId);
    assertTrue(json.statisticIdIsSet);
  }

  /**
   * Test Json {@link Json#state()}.
   * <p>
   * Method under test: {@link Json#state()}
   */
  @Test
  @DisplayName("Test Json state()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StatisticValueState Json.state()"})
  void testJsonState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).state());
  }

  /**
   * Test Json {@link Json#statisticId()}.
   * <p>
   * Method under test: {@link Json#statisticId()}
   */
  @Test
  @DisplayName("Test Json statisticId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.statisticId()"})
  void testJsonStatisticId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).statisticId());
  }

  /**
   * Test Json {@link Json#value()}.
   * <p>
   * Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).value());
  }
}
