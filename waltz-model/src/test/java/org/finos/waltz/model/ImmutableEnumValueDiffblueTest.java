package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.ImmutableEnumValue.Builder;
import org.finos.waltz.model.ImmutableEnumValue.Json;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEnumValueDiffblueTest {
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
  @MethodsUnderTest({"ImmutableEnumValue Builder.build()", "Builder Builder.description(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableEnumValue actualImmutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Assert
    assertEquals("Icon Color", actualImmutableEnumValue.iconColor());
    assertEquals("Icon", actualImmutableEnumValue.icon());
    assertEquals("Key", actualImmutableEnumValue.key());
    assertEquals("Name", actualImmutableEnumValue.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableEnumValue.description());
    assertEquals("Type", actualImmutableEnumValue.type());
    assertEquals(0, actualImmutableEnumValue.position());
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
    Builder builderResult = ImmutableEnumValue.builder();
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableEnumValue actualImmutableEnumValue = builderResult.build();
    assertEquals(instance, actualImmutableEnumValue);
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
    Builder builderResult = ImmutableEnumValue.builder();

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
    Builder builderResult = ImmutableEnumValue.builder();

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
    Builder builderResult = ImmutableEnumValue.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EnumValue)} with {@code EnumValue}.
   *
   * <p>Method under test: {@link Builder#from(EnumValue)}
   */
  @Test
  @DisplayName("Test Builder from(EnumValue) with 'EnumValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EnumValue)"})
  void testBuilderFromWithEnumValue() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEnumValue actualImmutableEnumValue = builderResult.build();
    assertEquals(instance, actualImmutableEnumValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EnumValue)} with {@code EnumValue}.
   *
   * <p>Method under test: {@link Builder#from(EnumValue)}
   */
  @Test
  @DisplayName("Test Builder from(EnumValue) with 'EnumValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EnumValue)"})
  void testBuilderFromWithEnumValue2() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description(null)
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEnumValue actualImmutableEnumValue = builderResult.build();
    assertEquals(instance, actualImmutableEnumValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IconProvider) instance);

    // Assert
    ImmutableEnumValue actualImmutableEnumValue = builderResult.build();
    assertEquals(instance, actualImmutableEnumValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider2() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description(null)
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IconProvider) instance);

    // Assert
    ImmutableEnumValue actualImmutableEnumValue = builderResult.build();
    assertEquals(instance, actualImmutableEnumValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <ul>
   *   <li>Given {@code Icon}.
   *   <li>When {@link IconProvider} {@link IconProvider#icon()} return {@code Icon}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IconProvider) with 'IconProvider'; given 'Icon'; when IconProvider icon() return 'Icon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_givenIcon_whenIconProviderIconReturnIcon() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenReturn("Icon");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).icon();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IconProvider) with 'IconProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).icon();
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
    Builder builderResult = ImmutableEnumValue.builder();
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEnumValue actualImmutableEnumValue = builderResult.build();
    assertEquals(instance, actualImmutableEnumValue);
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
    Builder builderResult = ImmutableEnumValue.builder();
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description(null)
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEnumValue actualImmutableEnumValue = builderResult.build();
    assertEquals(instance, actualImmutableEnumValue);
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
    Builder builderResult = ImmutableEnumValue.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((PositionProvider) instance);

    // Assert
    ImmutableEnumValue actualImmutableEnumValue = builderResult.build();
    assertEquals(instance, actualImmutableEnumValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider2() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider3() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurableCategory.builder()
                    .allowPrimaryRatings(true)
                    .constrainingAssessmentDefinitionId(1L)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .icon("Icon")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .ratingEditorRole("Rating Editor Role")
                    .ratingSchemeId(1L)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider4() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description(null)
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#iconColor(String)}.
   *
   * <ul>
   *   <li>When {@code Icon Color}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#iconColor(String)}
   */
  @Test
  @DisplayName("Test Builder iconColor(String); when 'Icon Color'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.iconColor(String)"})
  void testBuilderIconColor_whenIconColor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act
    Builder actualIconColorResult = builderResult.iconColor("Icon Color");

    // Assert
    assertSame(builderResult, actualIconColorResult);
  }

  /**
   * Test Builder {@link Builder#icon(String)}.
   *
   * <ul>
   *   <li>When {@code Icon}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#icon(String)}
   */
  @Test
  @DisplayName("Test Builder icon(String); when 'Icon'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.icon(String)"})
  void testBuilderIcon_whenIcon_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act
    Builder actualIconResult = builderResult.icon("Icon");

    // Assert
    assertSame(builderResult, actualIconResult);
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
    Builder builderResult = ImmutableEnumValue.builder();

    // Act
    Builder actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
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
    Builder builderResult = ImmutableEnumValue.builder();

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
    Builder builderResult = ImmutableEnumValue.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
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
    Builder builderResult = ImmutableEnumValue.builder();

    // Act
    Builder actualTypeResult = builderResult.type("Type");

    // Assert
    assertSame(builderResult, actualTypeResult);
  }

  /**
   * Test {@link ImmutableEnumValue#copyOf(EnumValue)}.
   *
   * <ul>
   *   <li>Then return {@code Icon Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#copyOf(EnumValue)}
   */
  @Test
  @DisplayName("Test copyOf(EnumValue); then return 'Icon Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.copyOf(EnumValue)"})
  void testCopyOf_thenReturnIconColor() {
    // Arrange
    ImmutableEnumValue instance =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableEnumValue actualCopyOfResult = ImmutableEnumValue.copyOf(instance);

    // Assert
    assertEquals("Icon Color", actualCopyOfResult.iconColor());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(0, actualCopyOfResult.position());
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}, and {@link ImmutableEnumValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEnumValue#equals(Object)}
   *   <li>{@link ImmutableEnumValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();
    ImmutableEnumValue immutableEnumValue2 =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(immutableEnumValue, immutableEnumValue2);
    assertEquals(immutableEnumValue.hashCode(), immutableEnumValue2.hashCode());
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}, and {@link ImmutableEnumValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEnumValue#equals(Object)}
   *   <li>{@link ImmutableEnumValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(immutableEnumValue, immutableEnumValue);
    int expectedHashCodeResult = immutableEnumValue.hashCode();
    assertEquals(expectedHashCodeResult, immutableEnumValue.hashCode());
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Name")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEnumValue,
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEnumValue,
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Icon")
            .name("Name")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEnumValue,
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Icon")
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEnumValue,
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Icon")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEnumValue,
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEnumValue.equals(Object)",
    "int ImmutableEnumValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build(),
        "Different type to ImmutableEnumValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEnumValue#toString()}
   *   <li>{@link ImmutableEnumValue#description()}
   *   <li>{@link ImmutableEnumValue#icon()}
   *   <li>{@link ImmutableEnumValue#iconColor()}
   *   <li>{@link ImmutableEnumValue#key()}
   *   <li>{@link ImmutableEnumValue#name()}
   *   <li>{@link ImmutableEnumValue#position()}
   *   <li>{@link ImmutableEnumValue#type()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEnumValue.description()",
    "String ImmutableEnumValue.icon()",
    "String ImmutableEnumValue.iconColor()",
    "String ImmutableEnumValue.key()",
    "String ImmutableEnumValue.name()",
    "int ImmutableEnumValue.position()",
    "String ImmutableEnumValue.toString()",
    "String ImmutableEnumValue.type()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    String actualToStringResult = immutableEnumValue.toString();
    String actualDescriptionResult = immutableEnumValue.description();
    String actualIconResult = immutableEnumValue.icon();
    String actualIconColorResult = immutableEnumValue.iconColor();
    String actualKeyResult = immutableEnumValue.key();
    String actualNameResult = immutableEnumValue.name();
    int actualPositionResult = immutableEnumValue.position();

    // Assert
    assertEquals(
        "EnumValue{icon=Icon, name=Name, position=0, type=Type, key=Key, iconColor=Icon Color}",
        actualToStringResult);
    assertEquals("Icon Color", actualIconColorResult);
    assertEquals("Icon", actualIconResult);
    assertEquals("Key", actualKeyResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals("Type", immutableEnumValue.type());
    assertEquals(0, actualPositionResult);
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
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setIcon(String)}
   *   <li>{@link Json#setIconColor(String)}
   *   <li>{@link Json#setKey(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setType(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setIcon(String)",
    "void Json.setIconColor(String)",
    "void Json.setKey(String)",
    "void Json.setName(String)",
    "void Json.setType(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setIcon("Icon");
    actualJson.setIconColor("Icon Color");
    actualJson.setKey("Key");
    actualJson.setName("Name");
    actualJson.setType("Type");

    // Assert
    assertEquals("Icon Color", actualJson.iconColor);
    assertEquals("Icon", actualJson.icon);
    assertEquals("Key", actualJson.key);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals("Type", actualJson.type);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#icon()}.
   *
   * <p>Method under test: {@link Json#icon()}
   */
  @Test
  @DisplayName("Test Json icon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.icon()"})
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().icon());
  }

  /**
   * Test Json {@link Json#iconColor()}.
   *
   * <p>Method under test: {@link Json#iconColor()}
   */
  @Test
  @DisplayName("Test Json iconColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.iconColor()"})
  void testJsonIconColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().iconColor());
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
   * Test {@link ImmutableEnumValue#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEnumValue#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableEnumValue actualWithDescriptionResult = immutableEnumValue.withDescription("42");

    // Assert
    assertEquals(immutableEnumValue, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEnumValue#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEnumValue#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("42")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableEnumValue actualWithDescriptionResult = immutableEnumValue.withDescription("42");

    // Assert
    assertSame(immutableEnumValue, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEnumValue#withIcon(String)}.
   *
   * <p>Method under test: {@link ImmutableEnumValue#withIcon(String)}
   */
  @Test
  @DisplayName("Test withIcon(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withIcon(String)"})
  void testWithIcon() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("42")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableEnumValue actualWithIconResult = immutableEnumValue.withIcon("42");

    // Assert
    assertSame(immutableEnumValue, actualWithIconResult);
  }

  /**
   * Test {@link ImmutableEnumValue#withIconColor(String)}.
   *
   * <p>Method under test: {@link ImmutableEnumValue#withIconColor(String)}
   */
  @Test
  @DisplayName("Test withIconColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withIconColor(String)"})
  void testWithIconColor() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("42")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableEnumValue actualWithIconColorResult = immutableEnumValue.withIconColor("42");

    // Assert
    assertSame(immutableEnumValue, actualWithIconColorResult);
  }

  /**
   * Test {@link ImmutableEnumValue#withIconColor(String)}.
   *
   * <ul>
   *   <li>Then return iconColor is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#withIconColor(String)}
   */
  @Test
  @DisplayName("Test withIconColor(String); then return iconColor is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withIconColor(String)"})
  void testWithIconColor_thenReturnIconColorIs42() {
    // Arrange and Act
    ImmutableEnumValue actualWithIconColorResult =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build()
            .withIconColor("42");

    // Assert
    assertEquals("42", actualWithIconColorResult.iconColor());
    assertEquals("Icon", actualWithIconColorResult.icon());
    assertEquals("Key", actualWithIconColorResult.key());
    assertEquals("Name", actualWithIconColorResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIconColorResult.description());
    assertEquals("Type", actualWithIconColorResult.type());
    assertEquals(0, actualWithIconColorResult.position());
  }

  /**
   * Test {@link ImmutableEnumValue#withIcon(String)}.
   *
   * <ul>
   *   <li>Then return icon is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#withIcon(String)}
   */
  @Test
  @DisplayName("Test withIcon(String); then return icon is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withIcon(String)"})
  void testWithIcon_thenReturnIconIs42() {
    // Arrange and Act
    ImmutableEnumValue actualWithIconResult =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build()
            .withIcon("42");

    // Assert
    assertEquals("42", actualWithIconResult.icon());
    assertEquals("Icon Color", actualWithIconResult.iconColor());
    assertEquals("Key", actualWithIconResult.key());
    assertEquals("Name", actualWithIconResult.name());
    assertEquals("The characteristics of someone or something", actualWithIconResult.description());
    assertEquals("Type", actualWithIconResult.type());
    assertEquals(0, actualWithIconResult.position());
  }

  /**
   * Test {@link ImmutableEnumValue#withKey(String)}.
   *
   * <p>Method under test: {@link ImmutableEnumValue#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withKey(String)"})
  void testWithKey() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("42")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableEnumValue actualWithKeyResult = immutableEnumValue.withKey("42");

    // Assert
    assertSame(immutableEnumValue, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableEnumValue#withKey(String)}.
   *
   * <ul>
   *   <li>Then return key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String); then return key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withKey(String)"})
  void testWithKey_thenReturnKeyIs42() {
    // Arrange and Act
    ImmutableEnumValue actualWithKeyResult =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build()
            .withKey("42");

    // Assert
    assertEquals("42", actualWithKeyResult.key());
    assertEquals("Icon Color", actualWithKeyResult.iconColor());
    assertEquals("Icon", actualWithKeyResult.icon());
    assertEquals("Name", actualWithKeyResult.name());
    assertEquals("The characteristics of someone or something", actualWithKeyResult.description());
    assertEquals("Type", actualWithKeyResult.type());
    assertEquals(0, actualWithKeyResult.position());
  }

  /**
   * Test {@link ImmutableEnumValue#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableEnumValue#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("42")
            .type("Type")
            .build();

    // Act
    ImmutableEnumValue actualWithNameResult = immutableEnumValue.withName("42");

    // Assert
    assertSame(immutableEnumValue, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEnumValue#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableEnumValue actualWithNameResult =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Icon Color", actualWithNameResult.iconColor());
    assertEquals("Icon", actualWithNameResult.icon());
    assertEquals("Key", actualWithNameResult.key());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals("Type", actualWithNameResult.type());
    assertEquals(0, actualWithNameResult.position());
  }

  /**
   * Test {@link ImmutableEnumValue#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableEnumValue#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableEnumValue actualWithPositionResult = immutableEnumValue.withPosition(0);

    // Assert
    assertSame(immutableEnumValue, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableEnumValue#withPosition(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Icon Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); when forty-two; then return 'Icon Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withPosition(int)"})
  void testWithPosition_whenFortyTwo_thenReturnIconColor() {
    // Arrange and Act
    ImmutableEnumValue actualWithPositionResult =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Icon Color", actualWithPositionResult.iconColor());
    assertEquals("Icon", actualWithPositionResult.icon());
    assertEquals("Key", actualWithPositionResult.key());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals("Type", actualWithPositionResult.type());
    assertEquals(42, actualWithPositionResult.position());
  }

  /**
   * Test {@link ImmutableEnumValue#withType(String)}.
   *
   * <p>Method under test: {@link ImmutableEnumValue#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withType(String)"})
  void testWithType() {
    // Arrange
    ImmutableEnumValue immutableEnumValue =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("42")
            .build();

    // Act
    ImmutableEnumValue actualWithTypeResult = immutableEnumValue.withType("42");

    // Assert
    assertSame(immutableEnumValue, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutableEnumValue#withType(String)}.
   *
   * <ul>
   *   <li>Then return type is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEnumValue#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String); then return type is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEnumValue ImmutableEnumValue.withType(String)"})
  void testWithType_thenReturnTypeIs42() {
    // Arrange and Act
    ImmutableEnumValue actualWithTypeResult =
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build()
            .withType("42");

    // Assert
    assertEquals("42", actualWithTypeResult.type());
    assertEquals("Icon Color", actualWithTypeResult.iconColor());
    assertEquals("Icon", actualWithTypeResult.icon());
    assertEquals("Key", actualWithTypeResult.key());
    assertEquals("Name", actualWithTypeResult.name());
    assertEquals("The characteristics of someone or something", actualWithTypeResult.description());
    assertEquals(0, actualWithTypeResult.position());
  }
}
