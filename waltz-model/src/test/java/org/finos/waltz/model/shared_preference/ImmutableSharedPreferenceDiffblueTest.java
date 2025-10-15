package org.finos.waltz.model.shared_preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreference.Builder;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSharedPreferenceDiffblueTest {
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
    "ImmutableSharedPreference Builder.build()",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableSharedPreference actualImmutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableSharedPreference.lastUpdatedBy());
    assertEquals("42", actualImmutableSharedPreference.value());
    assertEquals("Category", actualImmutableSharedPreference.category());
    assertEquals("Key", actualImmutableSharedPreference.key());
    assertSame(lastUpdatedAt, actualImmutableSharedPreference.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#category(String)}.
   *
   * <ul>
   *   <li>When {@code Category}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#category(String)}
   */
  @Test
  @DisplayName("Test Builder category(String); when 'Category'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.category(String)"})
  void testBuilderCategory_whenCategory_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSharedPreference.builder();

    // Act
    Builder actualCategoryResult = builderResult.category("Category");

    // Assert
    assertSame(builderResult, actualCategoryResult);
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
    Builder builderResult = ImmutableSharedPreference.builder();
    ImmutableSharedPreference instance =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act and Assert
    ImmutableSharedPreference actualImmutableSharedPreference =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableSharedPreference);
    ImmutableSharedPreference actualImmutableSharedPreference2 = builderResult.build();
    assertEquals(instance, actualImmutableSharedPreference2);
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
    Builder builderResult = ImmutableSharedPreference.builder();

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
    Builder builderResult = ImmutableSharedPreference.builder();

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
    Builder builderResult = ImmutableSharedPreference.builder();

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
   * Test Builder {@link Builder#from(SharedPreference)} with {@code SharedPreference}.
   *
   * <p>Method under test: {@link Builder#from(SharedPreference)}
   */
  @Test
  @DisplayName("Test Builder from(SharedPreference) with 'SharedPreference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SharedPreference)"})
  void testBuilderFromWithSharedPreference() {
    // Arrange
    Builder builderResult = ImmutableSharedPreference.builder();
    ImmutableSharedPreference instance =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSharedPreference actualImmutableSharedPreference = builderResult.build();
    assertEquals(instance, actualImmutableSharedPreference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String); when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSharedPreference.builder();

    // Act
    Builder actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
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
    Builder builderResult = ImmutableSharedPreference.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSharedPreference.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#copyOf(SharedPreference)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#copyOf(SharedPreference)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SharedPreference); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreference ImmutableSharedPreference.copyOf(SharedPreference)"
  })
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableSharedPreference instance =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreference actualCopyOfResult = ImmutableSharedPreference.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Category", actualCopyOfResult.category());
    assertEquals("Key", actualCopyOfResult.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}, and {@link
   * ImmutableSharedPreference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreference#equals(Object)}
   *   <li>{@link ImmutableSharedPreference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();
    ImmutableSharedPreference immutableSharedPreference2 =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSharedPreference, immutableSharedPreference2);
    assertEquals(immutableSharedPreference.hashCode(), immutableSharedPreference2.hashCode());
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}, and {@link
   * ImmutableSharedPreference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreference#equals(Object)}
   *   <li>{@link ImmutableSharedPreference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSharedPreference, immutableSharedPreference);
    int expectedHashCodeResult = immutableSharedPreference.hashCode();
    assertEquals(expectedHashCodeResult, immutableSharedPreference.hashCode());
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("2020-03-01")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreference,
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("2020-03-01")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreference,
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreference,
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreference,
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("2020-03-01")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreference,
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSharedPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreference.equals(Object)",
    "int ImmutableSharedPreference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build(),
        "Different type to ImmutableSharedPreference");
  }

  /**
   * Test {@link ImmutableSharedPreference#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) LastUpdatedBy is {@code Json}.
   *   <li>Then return category is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) LastUpdatedBy is 'Json'; then return category is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreference ImmutableSharedPreference.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonLastUpdatedByIsJson_thenReturnCategoryIsJson() {
    // Arrange
    Json json = new Json();
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setKey("Json");
    json.setCategory("Json");
    json.setValue("Json");

    // Act
    ImmutableSharedPreference actualFromJsonResult = ImmutableSharedPreference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.category());
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Test {@link ImmutableSharedPreference#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt is {@link Json} (default constructor) {@link
   *       Json#lastUpdatedAt}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return lastUpdatedAt is Json (default constructor) lastUpdatedAt")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreference ImmutableSharedPreference.fromJson(Json)"})
  void testFromJson_thenReturnLastUpdatedAtIsJsonLastUpdatedAt() {
    // Arrange
    Json json = new Json();
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setKey("Json");
    json.setCategory("Json");
    json.setValue("Json");

    // Act
    ImmutableSharedPreference actualFromJsonResult = ImmutableSharedPreference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.category());
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.value());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreference#toString()}
   *   <li>{@link ImmutableSharedPreference#category()}
   *   <li>{@link ImmutableSharedPreference#key()}
   *   <li>{@link ImmutableSharedPreference#lastUpdatedAt()}
   *   <li>{@link ImmutableSharedPreference#lastUpdatedBy()}
   *   <li>{@link ImmutableSharedPreference#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSharedPreference.category()",
    "String ImmutableSharedPreference.key()",
    "LocalDateTime ImmutableSharedPreference.lastUpdatedAt()",
    "String ImmutableSharedPreference.lastUpdatedBy()",
    "String ImmutableSharedPreference.toString()",
    "String ImmutableSharedPreference.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act
    String actualToStringResult = immutableSharedPreference.toString();
    String actualCategoryResult = immutableSharedPreference.category();
    String actualKeyResult = immutableSharedPreference.key();
    LocalDateTime actualLastUpdatedAtResult = immutableSharedPreference.lastUpdatedAt();
    String actualLastUpdatedByResult = immutableSharedPreference.lastUpdatedBy();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("42", immutableSharedPreference.value());
    assertEquals("Category", actualCategoryResult);
    assertEquals("Key", actualKeyResult);
    assertEquals(
        "SharedPreference{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, key=Key, category=Category,"
            + " value=42}",
        actualToStringResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#category()}.
   *
   * <p>Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().category());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCategory(String)}
   *   <li>{@link Json#setKey(String)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCategory(String)",
    "void Json.setKey(String)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setValue(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCategory("Category");
    actualJson.setKey("Key");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setValue("42");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#key()}.
   *
   * <p>Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().key());
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
   * Test Json {@link Json#value()}.
   *
   * <p>Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().value());
  }

  /**
   * Test {@link ImmutableSharedPreference#withCategory(String)}.
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withCategory(String)}
   */
  @Test
  @DisplayName("Test withCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreference ImmutableSharedPreference.withCategory(String)"})
  void testWithCategory() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("42")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreference actualWithCategoryResult =
        immutableSharedPreference.withCategory("42");

    // Assert
    assertSame(immutableSharedPreference, actualWithCategoryResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#withCategory(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withCategory(String)}
   */
  @Test
  @DisplayName(
      "Test withCategory(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreference ImmutableSharedPreference.withCategory(String)"})
  void testWithCategory_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSharedPreference actualWithCategoryResult =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build()
            .withCategory("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithCategoryResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithCategoryResult.lastUpdatedBy());
    assertEquals("42", actualWithCategoryResult.category());
    assertEquals("42", actualWithCategoryResult.value());
    assertEquals("Key", actualWithCategoryResult.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#withKey(String)}.
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreference ImmutableSharedPreference.withKey(String)"})
  void testWithKey() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreference actualWithKeyResult = immutableSharedPreference.withKey("42");

    // Assert
    assertSame(immutableSharedPreference, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#withKey(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreference ImmutableSharedPreference.withKey(String)"})
  void testWithKey_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSharedPreference actualWithKeyResult =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build()
            .withKey("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKeyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithKeyResult.lastUpdatedBy());
    assertEquals("42", actualWithKeyResult.key());
    assertEquals("42", actualWithKeyResult.value());
    assertEquals("Category", actualWithKeyResult.category());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreference ImmutableSharedPreference.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreference actualWithLastUpdatedAtResult =
        immutableSharedPreference.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSharedPreference, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreference ImmutableSharedPreference.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreference actualWithLastUpdatedByResult =
        immutableSharedPreference.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableSharedPreference, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreference ImmutableSharedPreference.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSharedPreference actualWithLastUpdatedByResult =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("42", actualWithLastUpdatedByResult.value());
    assertEquals("Category", actualWithLastUpdatedByResult.category());
    assertEquals("Key", actualWithLastUpdatedByResult.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#withValue(String)}.
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreference ImmutableSharedPreference.withValue(String)"})
  void testWithValue() {
    // Arrange
    ImmutableSharedPreference immutableSharedPreference =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreference actualWithValueResult = immutableSharedPreference.withValue("42");

    // Assert
    assertSame(immutableSharedPreference, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableSharedPreference#withValue(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreference#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreference ImmutableSharedPreference.withValue(String)"})
  void testWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSharedPreference actualWithValueResult =
        ImmutableSharedPreference.builder()
            .category("Category")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .value("value")
            .build()
            .withValue("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithValueResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithValueResult.lastUpdatedBy());
    assertEquals("42", actualWithValueResult.value());
    assertEquals("Category", actualWithValueResult.category());
    assertEquals("Key", actualWithValueResult.key());
    assertSame(ofResult, toLocalDateResult);
  }
}
