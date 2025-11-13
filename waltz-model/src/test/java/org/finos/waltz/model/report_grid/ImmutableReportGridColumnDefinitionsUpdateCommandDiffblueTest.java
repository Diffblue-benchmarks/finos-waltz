package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.report_grid.ImmutableReportGridColumnDefinitionsUpdateCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridColumnDefinitionsUpdateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridColumnDefinitionsUpdateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDerivedColumnDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDerivedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllDerivedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDerivedColumnDefinitions(Iterable)"})
  void testBuilderAddAllDerivedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act
    Builder actualAddAllDerivedColumnDefinitionsResult =
        builderResult.addAllDerivedColumnDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllFixedColumnDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllFixedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllFixedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllFixedColumnDefinitions(Iterable)"})
  void testBuilderAddAllFixedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act
    Builder actualAddAllFixedColumnDefinitionsResult =
        builderResult.addAllFixedColumnDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   * with {@code element}.
   *
   * <p>Method under test: {@link
   * Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)"
  })
  void testBuilderAddDerivedColumnDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridDerivedColumnDefinition.Json element =
        new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    Builder actualAddDerivedColumnDefinitionsResult =
        builderResult.addDerivedColumnDefinitions(element);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        builderResult.build().derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(element, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   * with {@code elements}.
   *
   * <p>Method under test: {@link
   * Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  @DisplayName(
      "Test Builder addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])"
  })
  void testBuilderAddDerivedColumnDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridDerivedColumnDefinition.Json json =
        new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    Builder actualAddDerivedColumnDefinitionsResult =
        builderResult.addDerivedColumnDefinitions(json);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        builderResult.build().derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(json, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)} with
   * {@code element}.
   *
   * <p>Method under test: {@link
   * Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder addFixedColumnDefinitions(ReportGridFixedColumnDefinition) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFixedColumnDefinitions(ReportGridFixedColumnDefinition)"})
  void testBuilderAddFixedColumnDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridFixedColumnDefinition.Json element =
        new ImmutableReportGridFixedColumnDefinition.Json();

    // Act
    Builder actualAddFixedColumnDefinitionsResult =
        builderResult.addFixedColumnDefinitions(element);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult =
        builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(element, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])} with
   * {@code elements}.
   *
   * <p>Method under test: {@link
   * Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  @DisplayName(
      "Test Builder addFixedColumnDefinitions(ReportGridFixedColumnDefinition[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])"
  })
  void testBuilderAddFixedColumnDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridFixedColumnDefinition.Json json =
        new ImmutableReportGridFixedColumnDefinition.Json();

    // Act
    Builder actualAddFixedColumnDefinitionsResult = builderResult.addFixedColumnDefinitions(json);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult =
        builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridColumnDefinitionsUpdateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableReportGridColumnDefinitionsUpdateCommand.builder()
            .build()
            .derivedColumnDefinitions()
            .isEmpty());
  }

  /**
   * Test Builder {@link Builder#derivedColumnDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#derivedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder derivedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.derivedColumnDefinitions(Iterable)"})
  void testBuilderDerivedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act
    Builder actualDerivedColumnDefinitionsResult =
        builderResult.derivedColumnDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#fixedColumnDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fixedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder fixedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fixedColumnDefinitions(Iterable)"})
  void testBuilderFixedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act
    Builder actualFixedColumnDefinitionsResult =
        builderResult.fixedColumnDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridColumnDefinitionsUpdateCommand)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridColumnDefinitionsUpdateCommand); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridColumnDefinitionsUpdateCommand)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link
   * ImmutableReportGridColumnDefinitionsUpdateCommand#copyOf(ReportGridColumnDefinitionsUpdateCommand)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return derivedColumnDefinitions Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridColumnDefinitionsUpdateCommand#copyOf(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridColumnDefinitionsUpdateCommand); when builder build; then return derivedColumnDefinitions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.copyOf(ReportGridColumnDefinitionsUpdateCommand)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnDerivedColumnDefinitionsEmpty() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand instance =
        ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualCopyOfResult =
        ImmutableReportGridColumnDefinitionsUpdateCommand.copyOf(instance);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualCopyOfResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualCopyOfResult.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}, and {@link
   * ImmutableReportGridColumnDefinitionsUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
    "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand
        immutableReportGridColumnDefinitionsUpdateCommand =
            ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build();
    ImmutableReportGridColumnDefinitionsUpdateCommand
        immutableReportGridColumnDefinitionsUpdateCommand2 =
            ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build();

    // Act and Assert
    assertEquals(
        immutableReportGridColumnDefinitionsUpdateCommand,
        immutableReportGridColumnDefinitionsUpdateCommand2);
    assertEquals(
        immutableReportGridColumnDefinitionsUpdateCommand.hashCode(),
        immutableReportGridColumnDefinitionsUpdateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}, and {@link
   * ImmutableReportGridColumnDefinitionsUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
    "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand
        immutableReportGridColumnDefinitionsUpdateCommand =
            ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build();

    // Act and Assert
    assertEquals(
        immutableReportGridColumnDefinitionsUpdateCommand,
        immutableReportGridColumnDefinitionsUpdateCommand);
    int expectedHashCodeResult = immutableReportGridColumnDefinitionsUpdateCommand.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableReportGridColumnDefinitionsUpdateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
    "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    builderResult.addFixedColumnDefinitions(
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    // Act and Assert
    assertNotEquals(
        builderResult.build(), ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
    "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    builderResult.addDerivedColumnDefinitions(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    // Act and Assert
    assertNotEquals(
        builderResult.build(), ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
    "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build(), null);
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
    "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build(),
        "Different type to ImmutableReportGridColumnDefinitionsUpdateCommand");
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       ImmutableReportGridFixedColumnDefinition.Json} (default constructor).
   *   <li>Then return fixedColumnDefinitions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return fixedColumnDefinitions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnFixedColumnDefinitionsSizeIsOne() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> fixedColumnDefinitions = new ArrayList<>();
    ImmutableReportGridFixedColumnDefinition.Json json =
        new ImmutableReportGridFixedColumnDefinition.Json();
    fixedColumnDefinitions.add(json);

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(new ImmutableReportGridDerivedColumnDefinition.Json());

    Json json2 = new Json();
    json2.setFixedColumnDefinitions(fixedColumnDefinitions);
    json2.setDerivedColumnDefinitions(derivedColumnDefinitions);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult =
        ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(json2);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult =
        actualFromJsonResult.fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return fixedColumnDefinitions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return fixedColumnDefinitions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"
  })
  void testFromJson_thenReturnFixedColumnDefinitionsEmpty() {
    // Arrange
    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(new ImmutableReportGridDerivedColumnDefinition.Json());

    Json json = new Json();
    json.setFixedColumnDefinitions(null);
    json.setDerivedColumnDefinitions(derivedColumnDefinitions);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult =
        ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.fixedColumnDefinitions().isEmpty());
    assertEquals(derivedColumnDefinitions, actualFromJsonResult.derivedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return fixedColumnDefinitions is {@link Json} (default constructor) {@link
   *       Json#fixedColumnDefinitions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return fixedColumnDefinitions is Json (default constructor) fixedColumnDefinitions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"
  })
  void testFromJson_thenReturnFixedColumnDefinitionsIsJsonFixedColumnDefinitions() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult =
        ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.derivedColumnDefinitions().isEmpty());
    List<ReportGridFixedColumnDefinition> expectedFixedColumnDefinitionsResult =
        json.fixedColumnDefinitions;
    assertSame(expectedFixedColumnDefinitionsResult, actualFromJsonResult.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return fixedColumnDefinitions size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return fixedColumnDefinitions size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"
  })
  void testFromJson_thenReturnFixedColumnDefinitionsSizeIsTwo() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> fixedColumnDefinitions = new ArrayList<>();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    fixedColumnDefinitions.add(
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    ImmutableReportGridFixedColumnDefinition.Json json =
        new ImmutableReportGridFixedColumnDefinition.Json();
    fixedColumnDefinitions.add(json);

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(new ImmutableReportGridDerivedColumnDefinition.Json());

    Json json2 = new Json();
    json2.setFixedColumnDefinitions(fixedColumnDefinitions);
    json2.setDerivedColumnDefinitions(derivedColumnDefinitions);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult =
        ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(json2);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult =
        actualFromJsonResult.fixedColumnDefinitions();
    assertEquals(2, fixedColumnDefinitionsResult.size());
    assertTrue(
        fixedColumnDefinitionsResult.get(0) instanceof ImmutableReportGridFixedColumnDefinition);
    ReportGridFixedColumnDefinition getResult = fixedColumnDefinitionsResult.get(1);
    assertTrue(getResult instanceof ImmutableReportGridFixedColumnDefinition.Json);
    assertSame(json, getResult);
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) DerivedColumnDefinitions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) DerivedColumnDefinitions is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonDerivedColumnDefinitionsIsNull() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> fixedColumnDefinitions = new ArrayList<>();
    ImmutableReportGridFixedColumnDefinition.Json json =
        new ImmutableReportGridFixedColumnDefinition.Json();
    fixedColumnDefinitions.add(json);

    Json json2 = new Json();
    json2.setFixedColumnDefinitions(fixedColumnDefinitions);
    json2.setDerivedColumnDefinitions(null);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult =
        ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(json2);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult =
        actualFromJsonResult.fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertTrue(actualFromJsonResult.derivedColumnDefinitions().isEmpty());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#toString()}
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#derivedColumnDefinitions()}
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#fixedColumnDefinitions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableReportGridColumnDefinitionsUpdateCommand.derivedColumnDefinitions()",
    "List ImmutableReportGridColumnDefinitionsUpdateCommand.fixedColumnDefinitions()",
    "String ImmutableReportGridColumnDefinitionsUpdateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand
        immutableReportGridColumnDefinitionsUpdateCommand =
            ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build();

    // Act
    String actualToStringResult = immutableReportGridColumnDefinitionsUpdateCommand.toString();
    List<ReportGridDerivedColumnDefinition> actualDerivedColumnDefinitionsResult =
        immutableReportGridColumnDefinitionsUpdateCommand.derivedColumnDefinitions();
    List<ReportGridFixedColumnDefinition> actualFixedColumnDefinitionsResult =
        immutableReportGridColumnDefinitionsUpdateCommand.fixedColumnDefinitions();

    // Assert
    assertEquals(
        "ReportGridColumnDefinitionsUpdateCommand{fixedColumnDefinitions=[], derivedColumnDefinitions=[]}",
        actualToStringResult);
    assertTrue(actualDerivedColumnDefinitionsResult.isEmpty());
    assertSame(actualDerivedColumnDefinitionsResult, actualFixedColumnDefinitionsResult);
  }

  /**
   * Test Json {@link Json#derivedColumnDefinitions()}.
   *
   * <p>Method under test: {@link Json#derivedColumnDefinitions()}
   */
  @Test
  @DisplayName("Test Json derivedColumnDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.derivedColumnDefinitions()"})
  void testJsonDerivedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().derivedColumnDefinitions());
  }

  /**
   * Test Json {@link Json#fixedColumnDefinitions()}.
   *
   * <p>Method under test: {@link Json#fixedColumnDefinitions()}
   */
  @Test
  @DisplayName("Test Json fixedColumnDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.fixedColumnDefinitions()"})
  void testJsonFixedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fixedColumnDefinitions());
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
    assertTrue(actualJson.derivedColumnDefinitions.isEmpty());
    assertTrue(actualJson.fixedColumnDefinitions.isEmpty());
  }

  /**
   * Test {@link
   * ImmutableReportGridColumnDefinitionsUpdateCommand#withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   * with {@code ReportGridDerivedColumnDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridColumnDefinitionsUpdateCommand#withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[]) with 'ReportGridDerivedColumnDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])"
  })
  void testWithDerivedColumnDefinitionsWithReportGridDerivedColumnDefinition() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand
        immutableReportGridColumnDefinitionsUpdateCommand =
            ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualWithDerivedColumnDefinitionsResult =
        immutableReportGridColumnDefinitionsUpdateCommand.withDerivedColumnDefinitions(
            ImmutableReportGridDerivedColumnDefinition.builder()
                .columnDescription("Column Description")
                .derivationScript("Derivation Script")
                .displayName("Display Name")
                .externalId("42")
                .gridColumnId(1L)
                .id(1L)
                .position(1)
                .build());

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithDerivedColumnDefinitionsResult.derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    ReportGridDerivedColumnDefinition getResult = derivedColumnDefinitionsResult.get(0);
    assertTrue(getResult instanceof ImmutableReportGridDerivedColumnDefinition);
    assertEquals("Column Description", getResult.columnDescription());
    assertEquals("Derivation Script", getResult.derivationScript());
    assertEquals("Display Name", getResult.displayName());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.gridColumnId().longValue());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, getResult.kind());
    assertTrue(actualWithDerivedColumnDefinitionsResult.fixedColumnDefinitions().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableReportGridColumnDefinitionsUpdateCommand#withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   * with {@code ReportGridFixedColumnDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridColumnDefinitionsUpdateCommand#withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withFixedColumnDefinitions(ReportGridFixedColumnDefinition[]) with 'ReportGridFixedColumnDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])"
  })
  void testWithFixedColumnDefinitionsWithReportGridFixedColumnDefinition() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand
        immutableReportGridColumnDefinitionsUpdateCommand =
            ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualWithFixedColumnDefinitionsResult =
        immutableReportGridColumnDefinitionsUpdateCommand.withFixedColumnDefinitions(
            displayNameResult
                .entityFieldReference(
                    ImmutableEntityFieldReference.builder()
                        .description("The characteristics of someone or something")
                        .displayName("Display Name")
                        .entityKind(EntityKind.ALL)
                        .fieldName("Field Name")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .build())
                .externalId("42")
                .gridColumnId(1L)
                .id(1L)
                .position(1)
                .build());

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult =
        actualWithFixedColumnDefinitionsResult.fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    ReportGridFixedColumnDefinition getResult = fixedColumnDefinitionsResult.get(0);
    assertTrue(getResult.entityFieldReference() instanceof ImmutableEntityFieldReference);
    assertTrue(getResult instanceof ImmutableReportGridFixedColumnDefinition);
    assertEquals("Column Description", getResult.columnDescription());
    assertEquals("Column Name", getResult.columnName());
    assertEquals("Display Name", getResult.displayName());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.columnEntityId().longValue());
    assertEquals(1L, getResult.columnQualifierId().longValue());
    assertEquals(1L, getResult.gridColumnId().longValue());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(EntityKind.ALL, getResult.columnEntityKind());
    assertEquals(EntityKind.ALL, getResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, getResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, getResult.additionalColumnOptions());
    assertTrue(actualWithFixedColumnDefinitionsResult.derivedColumnDefinitions().isEmpty());
  }
}
