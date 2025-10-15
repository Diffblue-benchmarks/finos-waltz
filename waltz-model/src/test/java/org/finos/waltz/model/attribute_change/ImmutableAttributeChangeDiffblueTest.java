package org.finos.waltz.model.attribute_change;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.attribute_change.ImmutableAttributeChange.Builder;
import org.finos.waltz.model.attribute_change.ImmutableAttributeChange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttributeChangeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttributeChange Builder.build()",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult = ImmutableAttributeChange.builder().changeUnitId(1L).id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableAttributeChange actualImmutableAttributeChange =
        actualIdResult
            .id(id)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableAttributeChange.lastUpdatedBy());
    assertEquals("42", actualImmutableAttributeChange.newValue());
    assertEquals("42", actualImmutableAttributeChange.oldValue());
    assertEquals("Name", actualImmutableAttributeChange.name());
    assertEquals("Provenance", actualImmutableAttributeChange.provenance());
    assertEquals("Type", actualImmutableAttributeChange.type());
    assertEquals(1L, actualImmutableAttributeChange.changeUnitId());
    assertSame(lastUpdatedAt, actualImmutableAttributeChange.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#changeUnitId(long)}.
   *
   * <p>Method under test: {@link Builder#changeUnitId(long)}
   */
  @Test
  @DisplayName("Test Builder changeUnitId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeUnitId(long)"})
  void testBuilderChangeUnitId() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    // Act
    Builder actualChangeUnitIdResult = builderResult.changeUnitId(1L);

    // Assert
    assertSame(builderResult, actualChangeUnitIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AttributeChange)} with {@code AttributeChange}.
   *
   * <p>Method under test: {@link Builder#from(AttributeChange)}
   */
  @Test
  @DisplayName("Test Builder from(AttributeChange) with 'AttributeChange'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttributeChange)"})
  void testBuilderFromWithAttributeChange() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();
    ImmutableAttributeChange instance =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttributeChange actualImmutableAttributeChange = builderResult.build();
    assertEquals(instance, actualImmutableAttributeChange);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();
    ImmutableAttributeChange instance =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    ImmutableAttributeChange actualImmutableAttributeChange =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAttributeChange);
    ImmutableAttributeChange actualImmutableAttributeChange2 = builderResult.build();
    assertEquals(instance, actualImmutableAttributeChange2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

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
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();
    ImmutableAttributeChange instance =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    ImmutableAttributeChange actualImmutableAttributeChange =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableAttributeChange);
    ImmutableAttributeChange actualImmutableAttributeChange2 = builderResult.build();
    assertEquals(instance, actualImmutableAttributeChange2);
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
    Builder builderResult = ImmutableAttributeChange.builder();

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
    Builder builderResult = ImmutableAttributeChange.builder();

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
    Builder builderResult = ImmutableAttributeChange.builder();

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
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();
    ImmutableAttributeChange instance =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    ImmutableAttributeChange actualImmutableAttributeChange =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAttributeChange);
    ImmutableAttributeChange actualImmutableAttributeChange2 = builderResult.build();
    assertEquals(instance, actualImmutableAttributeChange2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();
    ImmutableAttributeChange instance =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    ImmutableAttributeChange actualImmutableAttributeChange =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAttributeChange);
    ImmutableAttributeChange actualImmutableAttributeChange2 = builderResult.build();
    assertEquals(instance, actualImmutableAttributeChange2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableAttributeChange.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#newValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#newValue(String)}
   */
  @Test
  @DisplayName("Test Builder newValue(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newValue(String)"})
  void testBuilderNewValue_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    // Act
    Builder actualNewValueResult = builderResult.newValue("42");

    // Assert
    assertSame(builderResult, actualNewValueResult);
  }

  /**
   * Test Builder {@link Builder#oldValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#oldValue(String)}
   */
  @Test
  @DisplayName("Test Builder oldValue(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.oldValue(String)"})
  void testBuilderOldValue_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    // Act
    Builder actualOldValueResult = builderResult.oldValue("42");

    // Assert
    assertSame(builderResult, actualOldValueResult);
  }

  /**
   * Test Builder {@link Builder#type(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#type(String)}
   */
  @Test
  @DisplayName("Test Builder type(String); when 'Type'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.type(String)"})
  void testBuilderType_whenType_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttributeChange.builder();

    // Act
    Builder actualTypeResult = builderResult.type("Type");

    // Assert
    assertSame(builderResult, actualTypeResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#copyOf(AttributeChange)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#copyOf(AttributeChange)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttributeChange); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.copyOf(AttributeChange)"})
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAttributeChange instance =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualCopyOfResult = ImmutableAttributeChange.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.newValue());
    assertEquals("42", actualCopyOfResult.oldValue());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(1L, actualCopyOfResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}, and {@link
   * ImmutableAttributeChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttributeChange#equals(Object)}
   *   <li>{@link ImmutableAttributeChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();
    ImmutableAttributeChange immutableAttributeChange2 =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(immutableAttributeChange, immutableAttributeChange2);
    assertEquals(immutableAttributeChange.hashCode(), immutableAttributeChange2.hashCode());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}, and {@link
   * ImmutableAttributeChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttributeChange#equals(Object)}
   *   <li>{@link ImmutableAttributeChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(immutableAttributeChange, immutableAttributeChange);
    int expectedHashCodeResult = immutableAttributeChange.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttributeChange.hashCode());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(2L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("Name")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("Name")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Name")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttributeChange,
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttributeChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttributeChange.equals(Object)",
    "int ImmutableAttributeChange.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build(),
        "Different type to ImmutableAttributeChange");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttributeChange#changeUnitId()}
   *   <li>{@link ImmutableAttributeChange#lastUpdatedBy()}
   *   <li>{@link ImmutableAttributeChange#name()}
   *   <li>{@link ImmutableAttributeChange#newValue()}
   *   <li>{@link ImmutableAttributeChange#oldValue()}
   *   <li>{@link ImmutableAttributeChange#type()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableAttributeChange.changeUnitId()",
    "String ImmutableAttributeChange.lastUpdatedBy()",
    "String ImmutableAttributeChange.name()",
    "String ImmutableAttributeChange.newValue()",
    "String ImmutableAttributeChange.oldValue()",
    "String ImmutableAttributeChange.type()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    long actualChangeUnitIdResult = immutableAttributeChange.changeUnitId();
    String actualLastUpdatedByResult = immutableAttributeChange.lastUpdatedBy();
    String actualNameResult = immutableAttributeChange.name();
    String actualNewValueResult = immutableAttributeChange.newValue();
    String actualOldValueResult = immutableAttributeChange.oldValue();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("42", actualNewValueResult);
    assertEquals("42", actualOldValueResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Type", immutableAttributeChange.type());
    assertEquals(1L, actualChangeUnitIdResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#id()}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttributeChange.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#changeUnitId()}.
   *
   * <p>Method under test: {@link Json#changeUnitId()}
   */
  @Test
  @DisplayName("Test Json changeUnitId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.changeUnitId()"})
  void testJsonChangeUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeUnitId());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.newValue);
    assertNull(actualJson.oldValue);
    assertNull(actualJson.provenance);
    assertNull(actualJson.type);
    assertNull(actualJson.lastUpdatedAt);
    assertEquals(0L, actualJson.changeUnitId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.changeUnitIdIsSet);
  }

  /**
   * Test Json {@link Json#newValue()}.
   *
   * <p>Method under test: {@link Json#newValue()}
   */
  @Test
  @DisplayName("Test Json newValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.newValue()"})
  void testJsonNewValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newValue());
  }

  /**
   * Test Json {@link Json#oldValue()}.
   *
   * <p>Method under test: {@link Json#oldValue()}
   */
  @Test
  @DisplayName("Test Json oldValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.oldValue()"})
  void testJsonOldValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().oldValue());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#setChangeUnitId(long)}.
   *
   * <p>Method under test: {@link Json#setChangeUnitId(long)}
   */
  @Test
  @DisplayName("Test Json setChangeUnitId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setChangeUnitId(long)"})
  void testJsonSetChangeUnitId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setChangeUnitId(1L);

    // Assert
    assertEquals(1L, json.changeUnitId);
    assertTrue(json.changeUnitIdIsSet);
  }

  /**
   * Test Json {@link Json#type()}.
   *
   * <p>Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test {@link ImmutableAttributeChange#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableAttributeChange.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#provenance()}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttributeChange.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableAttributeChange#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttributeChange.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AttributeChange{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance"
            + "=Provenance, changeUnitId=1, type=Type, newValue=42, oldValue=42}",
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttributeChange#withChangeUnitId(long)}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withChangeUnitId(long)}
   */
  @Test
  @DisplayName("Test withChangeUnitId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withChangeUnitId(long)"})
  void testWithChangeUnitId() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(42L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualWithChangeUnitIdResult =
        immutableAttributeChange.withChangeUnitId(42L);

    // Assert
    assertSame(immutableAttributeChange, actualWithChangeUnitIdResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withChangeUnitId(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withChangeUnitId(long)}
   */
  @Test
  @DisplayName(
      "Test withChangeUnitId(long); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withChangeUnitId(long)"})
  void testWithChangeUnitId_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttributeChange actualWithChangeUnitIdResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .withChangeUnitId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithChangeUnitIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithChangeUnitIdResult.lastUpdatedBy());
    assertEquals("42", actualWithChangeUnitIdResult.newValue());
    assertEquals("42", actualWithChangeUnitIdResult.oldValue());
    assertEquals("Name", actualWithChangeUnitIdResult.name());
    assertEquals("Provenance", actualWithChangeUnitIdResult.provenance());
    assertEquals("Type", actualWithChangeUnitIdResult.type());
    assertEquals(42L, actualWithChangeUnitIdResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAttributeChange actualWithIdResult = immutableAttributeChange.withId(optional);

    // Assert
    assertSame(immutableAttributeChange, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withId(Optional)"})
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(2L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAttributeChange actualWithIdResult = immutableAttributeChange.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("42", actualWithIdResult.newValue());
    assertEquals("42", actualWithIdResult.oldValue());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Type", actualWithIdResult.type());
    assertEquals(1L, actualWithIdResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualWithIdResult = immutableAttributeChange.withId(1L);

    // Assert
    assertSame(immutableAttributeChange, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withId(long)"})
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttributeChange actualWithIdResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("42", actualWithIdResult.newValue());
    assertEquals("42", actualWithIdResult.oldValue());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Type", actualWithIdResult.type());
    assertEquals(1L, actualWithIdResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttributeChange ImmutableAttributeChange.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualWithLastUpdatedAtResult =
        immutableAttributeChange.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAttributeChange, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualWithLastUpdatedByResult =
        immutableAttributeChange.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableAttributeChange, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttributeChange actualWithLastUpdatedByResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("42", actualWithLastUpdatedByResult.newValue());
    assertEquals("42", actualWithLastUpdatedByResult.oldValue());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals("Type", actualWithLastUpdatedByResult.type());
    assertEquals(1L, actualWithLastUpdatedByResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualWithNameResult = immutableAttributeChange.withName("42");

    // Assert
    assertSame(immutableAttributeChange, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withName(String)"})
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttributeChange actualWithNameResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.newValue());
    assertEquals("42", actualWithNameResult.oldValue());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("Type", actualWithNameResult.type());
    assertEquals(1L, actualWithNameResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withNewValue(String)}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withNewValue(String)}
   */
  @Test
  @DisplayName("Test withNewValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withNewValue(String)"})
  void testWithNewValue() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualWithNewValueResult = immutableAttributeChange.withNewValue("42");

    // Assert
    assertSame(immutableAttributeChange, actualWithNewValueResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withNewValue(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withNewValue(String)}
   */
  @Test
  @DisplayName(
      "Test withNewValue(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withNewValue(String)"})
  void testWithNewValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttributeChange actualWithNewValueResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("newValue")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .withNewValue("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNewValueResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNewValueResult.lastUpdatedBy());
    assertEquals("42", actualWithNewValueResult.newValue());
    assertEquals("42", actualWithNewValueResult.oldValue());
    assertEquals("Name", actualWithNewValueResult.name());
    assertEquals("Provenance", actualWithNewValueResult.provenance());
    assertEquals("Type", actualWithNewValueResult.type());
    assertEquals(1L, actualWithNewValueResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withOldValue(String)}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withOldValue(String)}
   */
  @Test
  @DisplayName("Test withOldValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withOldValue(String)"})
  void testWithOldValue() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualWithOldValueResult = immutableAttributeChange.withOldValue("42");

    // Assert
    assertSame(immutableAttributeChange, actualWithOldValueResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withOldValue(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withOldValue(String)}
   */
  @Test
  @DisplayName(
      "Test withOldValue(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withOldValue(String)"})
  void testWithOldValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttributeChange actualWithOldValueResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("oldValue")
            .provenance("Provenance")
            .type("Type")
            .build()
            .withOldValue("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithOldValueResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithOldValueResult.lastUpdatedBy());
    assertEquals("42", actualWithOldValueResult.newValue());
    assertEquals("42", actualWithOldValueResult.oldValue());
    assertEquals("Name", actualWithOldValueResult.name());
    assertEquals("Provenance", actualWithOldValueResult.provenance());
    assertEquals("Type", actualWithOldValueResult.type());
    assertEquals(1L, actualWithOldValueResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("42")
            .type("Type")
            .build();

    // Act
    ImmutableAttributeChange actualWithProvenanceResult =
        immutableAttributeChange.withProvenance("42");

    // Assert
    assertSame(immutableAttributeChange, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withProvenance(String)"})
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttributeChange actualWithProvenanceResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.newValue());
    assertEquals("42", actualWithProvenanceResult.oldValue());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals("Type", actualWithProvenanceResult.type());
    assertEquals(1L, actualWithProvenanceResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withType(String)}.
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withType(String)"})
  void testWithType() {
    // Arrange
    ImmutableAttributeChange immutableAttributeChange =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("42")
            .build();

    // Act
    ImmutableAttributeChange actualWithTypeResult = immutableAttributeChange.withType("42");

    // Assert
    assertSame(immutableAttributeChange, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutableAttributeChange#withType(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttributeChange#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttributeChange ImmutableAttributeChange.withType(String)"})
  void testWithType_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttributeChange actualWithTypeResult =
        ImmutableAttributeChange.builder()
            .changeUnitId(1L)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .newValue("42")
            .oldValue("42")
            .provenance("Provenance")
            .type("Type")
            .build()
            .withType("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithTypeResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithTypeResult.lastUpdatedBy());
    assertEquals("42", actualWithTypeResult.newValue());
    assertEquals("42", actualWithTypeResult.oldValue());
    assertEquals("42", actualWithTypeResult.type());
    assertEquals("Name", actualWithTypeResult.name());
    assertEquals("Provenance", actualWithTypeResult.provenance());
    assertEquals(1L, actualWithTypeResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }
}
