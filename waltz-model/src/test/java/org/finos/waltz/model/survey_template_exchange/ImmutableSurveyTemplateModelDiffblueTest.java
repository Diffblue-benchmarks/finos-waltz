package org.finos.waltz.model.survey_template_exchange;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyTemplateModel.Builder;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyTemplateModel.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateModelDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#issuanceRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.issuanceRole(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel =
        actualExternalIdResult
            .externalId(externalId)
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals("42", actualImmutableSurveyTemplateModel.ownerEmployeeId());
    assertEquals("Issuance Role", actualImmutableSurveyTemplateModel.issuanceRole());
    assertEquals("Name", actualImmutableSurveyTemplateModel.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSurveyTemplateModel.description());
    assertEquals(EntityKind.ALL, actualImmutableSurveyTemplateModel.targetEntityKind());
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
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
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole(null)
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
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
    Builder builderResult = ImmutableSurveyTemplateModel.builder();

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
    Builder builderResult = ImmutableSurveyTemplateModel.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description(null)
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider3() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole(null)
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();

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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
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
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description(null)
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
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
  void testBuilderFromWithNameProvider3() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole(null)
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
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
    Builder builderResult = ImmutableSurveyTemplateModel.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateModel)} with {@code SurveyTemplateModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplateModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateModel) with 'SurveyTemplateModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateModel)"})
  void testBuilderFromWithSurveyTemplateModel() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateModel)} with {@code SurveyTemplateModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplateModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateModel) with 'SurveyTemplateModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateModel)"})
  void testBuilderFromWithSurveyTemplateModel2() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description(null)
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateModel)} with {@code SurveyTemplateModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplateModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateModel) with 'SurveyTemplateModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateModel)"})
  void testBuilderFromWithSurveyTemplateModel3() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole(null)
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyTemplateModel actualImmutableSurveyTemplateModel = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateModel);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableSurveyTemplateModel.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#ownerEmployeeId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ownerEmployeeId(String)}
   */
  @Test
  @DisplayName("Test Builder ownerEmployeeId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ownerEmployeeId(String)"})
  void testBuilderOwnerEmployeeId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();

    // Act
    Builder actualOwnerEmployeeIdResult = builderResult.ownerEmployeeId("42");

    // Assert
    assertSame(builderResult, actualOwnerEmployeeIdResult);
  }

  /**
   * Test Builder {@link Builder#targetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#targetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder targetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetEntityKind(EntityKind)"})
  void testBuilderTargetEntityKind() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateModel.builder();

    // Act
    Builder actualTargetEntityKindResult = builderResult.targetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#copyOf(SurveyTemplateModel)}.
   *
   * <ul>
   *   <li>Then return ownerEmployeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#copyOf(SurveyTemplateModel)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyTemplateModel); then return ownerEmployeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.copyOf(SurveyTemplateModel)"
  })
  void testCopyOf_thenReturnOwnerEmployeeIdIs42() {
    // Arrange
    ImmutableSurveyTemplateModel instance =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateModel actualCopyOfResult = ImmutableSurveyTemplateModel.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.ownerEmployeeId());
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}, and {@link
   * ImmutableSurveyTemplateModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateModel#equals(Object)}
   *   <li>{@link ImmutableSurveyTemplateModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel2 =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyTemplateModel, immutableSurveyTemplateModel2);
    assertEquals(immutableSurveyTemplateModel.hashCode(), immutableSurveyTemplateModel2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}, and {@link
   * ImmutableSurveyTemplateModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateModel#equals(Object)}
   *   <li>{@link ImmutableSurveyTemplateModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyTemplateModel, immutableSurveyTemplateModel);
    int expectedHashCodeResult = immutableSurveyTemplateModel.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyTemplateModel.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateModel,
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Name")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateModel,
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("42")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateModel,
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateModel,
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateModel,
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateModel.equals(Object)",
    "int ImmutableSurveyTemplateModel.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableSurveyTemplateModel");
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyTemplateModel.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) IssuanceRole is {@code Json}.
   *   <li>Then return issuanceRole is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) IssuanceRole is 'Json'; then return issuanceRole is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.fromJson(Json)"})
  void testFromJson_givenAll_whenJsonIssuanceRoleIsJson_thenReturnIssuanceRoleIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole("Json");
    json.setOwnerEmployeeId("Json");

    // Act
    ImmutableSurveyTemplateModel actualFromJsonResult = ImmutableSurveyTemplateModel.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.issuanceRole());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.ownerEmployeeId());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Name is 'Json'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.fromJson(Json)"})
  void testFromJson_givenAll_whenJsonNameIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);
    json.setOwnerEmployeeId("Json");

    // Act
    ImmutableSurveyTemplateModel actualFromJsonResult = ImmutableSurveyTemplateModel.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.ownerEmployeeId());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code foo}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ExternalId is of 'foo'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.fromJson(Json)"})
  void testFromJson_givenOfFoo_whenJsonExternalIdIsOfFoo_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    Optional<String> externalId = Optional.of("foo");
    json.setExternalId(externalId);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);
    json.setOwnerEmployeeId("Json");

    // Act
    ImmutableSurveyTemplateModel actualFromJsonResult = ImmutableSurveyTemplateModel.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.ownerEmployeeId());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("The characteristics of someone or something");
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);
    json.setOwnerEmployeeId("Json");

    // Act
    ImmutableSurveyTemplateModel actualFromJsonResult = ImmutableSurveyTemplateModel.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.ownerEmployeeId());
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateModel#description()}
   *   <li>{@link ImmutableSurveyTemplateModel#issuanceRole()}
   *   <li>{@link ImmutableSurveyTemplateModel#name()}
   *   <li>{@link ImmutableSurveyTemplateModel#ownerEmployeeId()}
   *   <li>{@link ImmutableSurveyTemplateModel#targetEntityKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyTemplateModel.description()",
    "String ImmutableSurveyTemplateModel.issuanceRole()",
    "String ImmutableSurveyTemplateModel.name()",
    "String ImmutableSurveyTemplateModel.ownerEmployeeId()",
    "EntityKind ImmutableSurveyTemplateModel.targetEntityKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    String actualDescriptionResult = immutableSurveyTemplateModel.description();
    String actualIssuanceRoleResult = immutableSurveyTemplateModel.issuanceRole();
    String actualNameResult = immutableSurveyTemplateModel.name();
    String actualOwnerEmployeeIdResult = immutableSurveyTemplateModel.ownerEmployeeId();

    // Assert
    assertEquals("42", actualOwnerEmployeeIdResult);
    assertEquals("Issuance Role", actualIssuanceRoleResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, immutableSurveyTemplateModel.targetEntityKind());
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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#issuanceRole()}.
   *
   * <p>Method under test: {@link Json#issuanceRole()}
   */
  @Test
  @DisplayName("Test Json issuanceRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.issuanceRole()"})
  void testJsonIssuanceRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().issuanceRole());
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
    assertNull(actualJson.issuanceRole);
    assertNull(actualJson.name);
    assertNull(actualJson.ownerEmployeeId);
    assertNull(actualJson.targetEntityKind);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Test Json {@link Json#ownerEmployeeId()}.
   *
   * <p>Method under test: {@link Json#ownerEmployeeId()}
   */
  @Test
  @DisplayName("Test Json ownerEmployeeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ownerEmployeeId()"})
  void testJsonOwnerEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ownerEmployeeId());
  }

  /**
   * Test Json {@link Json#targetEntityKind()}.
   *
   * <p>Method under test: {@link Json#targetEntityKind()}
   */
  @Test
  @DisplayName("Test Json targetEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.targetEntityKind()"})
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyTemplateModel.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyTemplateModel{name=Name, externalId=42, targetEntityKind=ALL, ownerEmployeeId=42}",
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole(null)
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyTemplateModel.toString()"})
  void testToString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyTemplateModel{name=Name, externalId=42, targetEntityKind=ALL, issuanceRole=Issuance Role,"
            + " ownerEmployeeId=42}",
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateModel actualWithDescriptionResult =
        immutableSurveyTemplateModel.withDescription("42");

    // Assert
    assertEquals(immutableSurveyTemplateModel, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("42")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateModel actualWithDescriptionResult =
        immutableSurveyTemplateModel.withDescription("42");

    // Assert
    assertSame(immutableSurveyTemplateModel, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyTemplateModel actualWithExternalIdResult =
        immutableSurveyTemplateModel.withExternalId(optional);

    // Assert
    assertSame(immutableSurveyTemplateModel, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return ownerEmployeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; when of 'foo'; then return ownerEmployeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnOwnerEmployeeIdIs42() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSurveyTemplateModel actualWithExternalIdResult =
        immutableSurveyTemplateModel.withExternalId(optional);

    // Assert
    assertEquals("42", actualWithExternalIdResult.ownerEmployeeId());
    assertEquals("Issuance Role", actualWithExternalIdResult.issuanceRole());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateModel actualWithExternalIdResult =
        immutableSurveyTemplateModel.withExternalId("42");

    // Assert
    assertSame(immutableSurveyTemplateModel, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return ownerEmployeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return ownerEmployeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnOwnerEmployeeIdIs42() {
    // Arrange and Act
    ImmutableSurveyTemplateModel actualWithExternalIdResult =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("42", actualWithExternalIdResult.ownerEmployeeId());
    assertEquals("Issuance Role", actualWithExternalIdResult.issuanceRole());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withIssuanceRole(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withIssuanceRole(String)}
   */
  @Test
  @DisplayName("Test withIssuanceRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withIssuanceRole(String)"
  })
  void testWithIssuanceRole() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("42")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateModel actualWithIssuanceRoleResult =
        immutableSurveyTemplateModel.withIssuanceRole("42");

    // Assert
    assertSame(immutableSurveyTemplateModel, actualWithIssuanceRoleResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withIssuanceRole(String)}.
   *
   * <ul>
   *   <li>Then return issuanceRole is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withIssuanceRole(String)}
   */
  @Test
  @DisplayName("Test withIssuanceRole(String); then return issuanceRole is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withIssuanceRole(String)"
  })
  void testWithIssuanceRole_thenReturnIssuanceRoleIs42() {
    // Arrange and Act
    ImmutableSurveyTemplateModel actualWithIssuanceRoleResult =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withIssuanceRole("42");

    // Assert
    assertEquals("42", actualWithIssuanceRoleResult.issuanceRole());
    assertEquals("42", actualWithIssuanceRoleResult.ownerEmployeeId());
    assertEquals("Name", actualWithIssuanceRoleResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIssuanceRoleResult.description());
    assertEquals(EntityKind.ALL, actualWithIssuanceRoleResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("42")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateModel actualWithNameResult = immutableSurveyTemplateModel.withName("42");

    // Assert
    assertSame(immutableSurveyTemplateModel, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableSurveyTemplateModel actualWithNameResult =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.ownerEmployeeId());
    assertEquals("Issuance Role", actualWithNameResult.issuanceRole());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withOwnerEmployeeId(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withOwnerEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withOwnerEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withOwnerEmployeeId(String)"
  })
  void testWithOwnerEmployeeId() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateModel actualWithOwnerEmployeeIdResult =
        immutableSurveyTemplateModel.withOwnerEmployeeId("42");

    // Assert
    assertSame(immutableSurveyTemplateModel, actualWithOwnerEmployeeIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withOwnerEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return ownerEmployeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withOwnerEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withOwnerEmployeeId(String); then return ownerEmployeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withOwnerEmployeeId(String)"
  })
  void testWithOwnerEmployeeId_thenReturnOwnerEmployeeIdIs42() {
    // Arrange and Act
    ImmutableSurveyTemplateModel actualWithOwnerEmployeeIdResult =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("ownerEmployeeId")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withOwnerEmployeeId("42");

    // Assert
    assertEquals("42", actualWithOwnerEmployeeIdResult.ownerEmployeeId());
    assertEquals("Issuance Role", actualWithOwnerEmployeeIdResult.issuanceRole());
    assertEquals("Name", actualWithOwnerEmployeeIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOwnerEmployeeIdResult.description());
    assertEquals(EntityKind.ALL, actualWithOwnerEmployeeIdResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withTargetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind() {
    // Arrange
    ImmutableSurveyTemplateModel immutableSurveyTemplateModel =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateModel actualWithTargetEntityKindResult =
        immutableSurveyTemplateModel.withTargetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSurveyTemplateModel, actualWithTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateModel#withTargetEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return ownerEmployeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateModel#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetEntityKind(EntityKind); then return ownerEmployeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateModel ImmutableSurveyTemplateModel.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind_thenReturnOwnerEmployeeIdIs42() {
    // Arrange and Act
    ImmutableSurveyTemplateModel actualWithTargetEntityKindResult =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ACTOR)
            .build()
            .withTargetEntityKind(EntityKind.ALL);

    // Assert
    assertEquals("42", actualWithTargetEntityKindResult.ownerEmployeeId());
    assertEquals("Issuance Role", actualWithTargetEntityKindResult.issuanceRole());
    assertEquals("Name", actualWithTargetEntityKindResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithTargetEntityKindResult.description());
    assertEquals(EntityKind.ALL, actualWithTargetEntityKindResult.targetEntityKind());
  }
}
