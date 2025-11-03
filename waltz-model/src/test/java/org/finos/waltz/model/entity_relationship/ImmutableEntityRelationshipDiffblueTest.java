package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityRelationshipDiffblueTest {
  /**
   * Test {@link ImmutableEntityRelationship#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityRelationship#builder()}
   *   <li>{@link ImmutableEntityRelationship#description(String)}
   *   <li>{@link ImmutableEntityRelationship#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityRelationship#provenance(String)}
   *   <li>{@link ImmutableEntityRelationship#relationship(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableEntityRelationship Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.provenance(String)",
      "Builder Builder.relationship(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableEntityRelationship.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);
    Builder actualProvenanceResult = actualIdResult2.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.relationship("127.0.0.1"));
  }

  /**
   * Test Builder {@link Builder#a(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#a(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder a(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.a(EntityReference)"})
  void testBuilderA_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.a(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#b(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#b(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder b(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.b(EntityReference)"})
  void testBuilderB_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.b(mock(EntityReference.class)));
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
    Builder builderResult = ImmutableEntityRelationship.builder();
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
    Builder builderResult = ImmutableEntityRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationship)} with {@code EntityRelationship}.
   * <p>
   * Method under test: {@link Builder#from(EntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationship) with 'EntityRelationship'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationship)"})
  void testBuilderFromWithEntityRelationship() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    when(instance.a()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationship)} with {@code EntityRelationship}.
   * <p>
   * Method under test: {@link Builder#from(EntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationship) with 'EntityRelationship'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationship)"})
  void testBuilderFromWithEntityRelationship2() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    when(instance.b()).thenThrow(new IllegalStateException("instance"));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationship)} with {@code EntityRelationship}.
   * <p>
   * Method under test: {@link Builder#from(EntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationship) with 'EntityRelationship'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationship)"})
  void testBuilderFromWithEntityRelationship3() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationship)} with {@code EntityRelationship}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationship) with 'EntityRelationship'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationship)"})
  void testBuilderFromWithEntityRelationship_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.relationship()).thenReturn("127.0.0.1");
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationship();
    ImmutableEntityRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationship)} with {@code EntityRelationship}.
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationship) with 'EntityRelationship'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationship)"})
  void testBuilderFromWithEntityRelationship_thenBuilderBuildLastUpdatedByIs20200301() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.relationship()).thenReturn("127.0.0.1");
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationship();
    ImmutableEntityRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationship)} with {@code EntityRelationship}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationship) with 'EntityRelationship'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationship)"})
  void testBuilderFromWithEntityRelationship_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    when(instance.a()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
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
    Builder builderResult = ImmutableEntityRelationship.builder();
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
    Builder builderResult = ImmutableEntityRelationship.builder();
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
    Builder builderResult = ImmutableEntityRelationship.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableEntityRelationship.builder();
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
    Builder builderResult = ImmutableEntityRelationship.builder();
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
    Builder builderResult = ImmutableEntityRelationship.builder();
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
    Builder builderResult = ImmutableEntityRelationship.builder();

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
    Builder builderResult = ImmutableEntityRelationship.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
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
    Builder builderResult = ImmutableEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Json {@link Json#a()}.
   * <p>
   * Method under test: {@link Json#a()}
   */
  @Test
  @DisplayName("Test Json a()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.a()"})
  void testJsonA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).a());
  }

  /**
   * Test Json {@link Json#b()}.
   * <p>
   * Method under test: {@link Json#b()}
   */
  @Test
  @DisplayName("Test Json b()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.b()"})
  void testJsonB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).b());
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
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.relationship);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.a);
    assertNull(actualJson.b);
    assertFalse(actualJson.id.isPresent());
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
   * Test Json {@link Json#relationship()}.
   * <p>
   * Method under test: {@link Json#relationship()}
   */
  @Test
  @DisplayName("Test Json relationship()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.relationship()"})
  void testJsonRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relationship());
  }
}
