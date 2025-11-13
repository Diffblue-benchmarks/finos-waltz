package org.finos.waltz.web.json;

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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.web.json.ImmutableReportGridColumnJSON.Builder;
import org.finos.waltz.web.json.ImmutableReportGridColumnJSON.Json;
import org.finos.waltz.web.json.ReportGridDefinitionJSON.ReportGridColumnJSON;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridColumnJSONDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableReportGridColumnJSON actualImmutableReportGridColumnJSON =
        actualIdResult.id(id).name("Name").position(1).build();

    // Assert
    assertEquals("Name", actualImmutableReportGridColumnJSON.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableReportGridColumnJSON.description());
    assertEquals(1, actualImmutableReportGridColumnJSON.position());
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ImmutableReportGridColumnJSON instance =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableReportGridColumnJSON actualImmutableReportGridColumnJSON = builderResult.build();
    assertEquals(instance, actualImmutableReportGridColumnJSON);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

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
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ImmutableReportGridColumnJSON instance =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableReportGridColumnJSON actualImmutableReportGridColumnJSON = builderResult.build();
    assertEquals(instance, actualImmutableReportGridColumnJSON);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
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
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ImmutableReportGridColumnJSON instance =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableReportGridColumnJSON actualImmutableReportGridColumnJSON = builderResult.build();
    assertEquals(instance, actualImmutableReportGridColumnJSON);
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
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ImmutableReportGridColumnJSON instance =
        ImmutableReportGridColumnJSON.builder()
            .description(null)
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableReportGridColumnJSON actualImmutableReportGridColumnJSON = builderResult.build();
    assertEquals(instance, actualImmutableReportGridColumnJSON);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridColumnJSON)} with {@code ReportGridColumnJSON}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridColumnJSON)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridColumnJSON) with 'ReportGridColumnJSON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridColumnJSON)"})
  void testBuilderFromWithReportGridColumnJSON() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ImmutableReportGridColumnJSON instance =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridColumnJSON actualImmutableReportGridColumnJSON = builderResult.build();
    assertEquals(instance, actualImmutableReportGridColumnJSON);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridColumnJSON)} with {@code ReportGridColumnJSON}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridColumnJSON)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridColumnJSON) with 'ReportGridColumnJSON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridColumnJSON)"})
  void testBuilderFromWithReportGridColumnJSON2() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ImmutableReportGridColumnJSON instance =
        ImmutableReportGridColumnJSON.builder()
            .description(null)
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridColumnJSON actualImmutableReportGridColumnJSON = builderResult.build();
    assertEquals(instance, actualImmutableReportGridColumnJSON);
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
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

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
    Builder builderResult = ImmutableReportGridColumnJSON.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnJSON.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#copyOf(ReportGridColumnJSON)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#copyOf(ReportGridColumnJSON)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridColumnJSON); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.copyOf(ReportGridColumnJSON)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableReportGridColumnJSON instance =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableReportGridColumnJSON actualCopyOfResult =
        ImmutableReportGridColumnJSON.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#equals(Object)}, and {@link
   * ImmutableReportGridColumnJSON#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridColumnJSON#equals(Object)}
   *   <li>{@link ImmutableReportGridColumnJSON#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnJSON.equals(Object)",
    "int ImmutableReportGridColumnJSON.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON2 =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridColumnJSON, immutableReportGridColumnJSON2);
    assertEquals(
        immutableReportGridColumnJSON.hashCode(), immutableReportGridColumnJSON2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#equals(Object)}, and {@link
   * ImmutableReportGridColumnJSON#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridColumnJSON#equals(Object)}
   *   <li>{@link ImmutableReportGridColumnJSON#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnJSON.equals(Object)",
    "int ImmutableReportGridColumnJSON.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridColumnJSON, immutableReportGridColumnJSON);
    int expectedHashCodeResult = immutableReportGridColumnJSON.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridColumnJSON.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnJSON.equals(Object)",
    "int ImmutableReportGridColumnJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(2L)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridColumnJSON,
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnJSON.equals(Object)",
    "int ImmutableReportGridColumnJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("java.lang.Long")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridColumnJSON,
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnJSON.equals(Object)",
    "int ImmutableReportGridColumnJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(0)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridColumnJSON,
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnJSON.equals(Object)",
    "int ImmutableReportGridColumnJSON.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnJSON.equals(Object)",
    "int ImmutableReportGridColumnJSON.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build(),
        "Different type to ImmutableReportGridColumnJSON");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridColumnJSON#description()}
   *   <li>{@link ImmutableReportGridColumnJSON#name()}
   *   <li>{@link ImmutableReportGridColumnJSON#position()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableReportGridColumnJSON.description()",
    "String ImmutableReportGridColumnJSON.name()",
    "int ImmutableReportGridColumnJSON.position()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    String actualDescriptionResult = immutableReportGridColumnJSON.description();
    String actualNameResult = immutableReportGridColumnJSON.name();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, immutableReportGridColumnJSON.position());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#id()}.
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableReportGridColumnJSON.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridColumnJSON.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportGridColumnJSON{id=1, name=Name, position=1}",
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableReportGridColumnJSON actualWithDescriptionResult =
        immutableReportGridColumnJSON.withDescription("42");

    // Assert
    assertEquals(immutableReportGridColumnJSON, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} id one name {@code Name} position one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' id one name 'Name' position one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withDescription(String)"
  })
  void testWithDescription_thenReturnBuilderDescription42IdOneNameNamePositionOneBuild() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("42")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableReportGridColumnJSON actualWithDescriptionResult =
        immutableReportGridColumnJSON.withDescription("42");

    // Assert
    assertSame(immutableReportGridColumnJSON, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableReportGridColumnJSON actualWithIdResult =
        immutableReportGridColumnJSON.withId(optional);

    // Assert
    assertSame(immutableReportGridColumnJSON, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withId(Optional)"
  })
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnName() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableReportGridColumnJSON actualWithIdResult =
        immutableReportGridColumnJSON.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableReportGridColumnJSON actualWithIdResult = immutableReportGridColumnJSON.withId(1L);

    // Assert
    assertSame(immutableReportGridColumnJSON, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableReportGridColumnJSON actualWithIdResult =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("42")
            .position(1)
            .build();

    // Act
    ImmutableReportGridColumnJSON actualWithNameResult =
        immutableReportGridColumnJSON.withName("42");

    // Assert
    assertSame(immutableReportGridColumnJSON, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableReportGridColumnJSON actualWithNameResult =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.position());
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withPosition(int)"
  })
  void testWithPosition() {
    // Arrange
    ImmutableReportGridColumnJSON immutableReportGridColumnJSON =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(42)
            .build();

    // Act
    ImmutableReportGridColumnJSON actualWithPositionResult =
        immutableReportGridColumnJSON.withPosition(42);

    // Assert
    assertSame(immutableReportGridColumnJSON, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableReportGridColumnJSON#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnJSON#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnJSON ImmutableReportGridColumnJSON.withPosition(int)"
  })
  void testWithPosition_thenReturnName() {
    // Arrange and Act
    ImmutableReportGridColumnJSON actualWithPositionResult =
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(42, actualWithPositionResult.position());
  }
}
