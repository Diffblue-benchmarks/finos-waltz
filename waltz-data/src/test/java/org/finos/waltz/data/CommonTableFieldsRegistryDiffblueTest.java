package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.CommonTableFields;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ImmutableCommonTableFields;
import org.finos.waltz.schema.DefaultCatalog;
import org.finos.waltz.schema.DefaultSchema;
import org.finos.waltz.schema.tables.Actor;
import org.finos.waltz.schema.tables.AllocationScheme;
import org.finos.waltz.schema.tables.Application;
import org.finos.waltz.schema.tables.ApplicationGroup;
import org.finos.waltz.schema.tables.AssessmentDefinition;
import org.finos.waltz.schema.tables.ChangeInitiative;
import org.finos.waltz.schema.tables.ChangeSet;
import org.jooq.Catalog;
import org.jooq.Schema;
import org.jooq.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommonTableFieldsRegistryDiffblueTest {
  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>Then table return {@link AllocationScheme}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); then table return AllocationScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_thenTableReturnAllocationScheme() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.ALLOCATION_SCHEME, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof AllocationScheme);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>Then table return {@link AssessmentDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); then table return AssessmentDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_thenTableReturnAssessmentDefinition() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(
            EntityKind.ASSESSMENT_DEFINITION, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof AssessmentDefinition);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>Then table return {@link AssessmentDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); then table return AssessmentDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_thenTableReturnAssessmentDefinition2() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(
            EntityKind.ASSESSMENT_DEFINITION, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof AssessmentDefinition);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>Then table return {@link ChangeInitiative}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); then table return ChangeInitiative")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_thenTableReturnChangeInitiative() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.CHANGE_INITIATIVE, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof ChangeInitiative);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>Then table return {@link ChangeInitiative}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); then table return ChangeInitiative")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_thenTableReturnChangeInitiative2() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.CHANGE_INITIATIVE, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof ChangeInitiative);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>Then table Schema Catalog return {@link DefaultCatalog}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); then table Schema Catalog return DefaultCatalog")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_thenTableSchemaCatalogReturnDefaultCatalog() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.ALLOCATION_SCHEME, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof AllocationScheme);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(141, schema.getTables().size());
    assertEquals(schema, schema.getQualifiedName());
    assertEquals(schema, catalog);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code ACTOR}.
   *   <li>Then table return {@link Actor}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'ACTOR'; then table return Actor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenActor_thenTableReturnActor() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.ACTOR, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof Actor);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code ACTOR}.
   *   <li>Then table return {@link Actor}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'ACTOR'; then table return Actor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenActor_thenTableReturnActor2() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.ACTOR, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof Actor);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'ALL'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenAll_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.ALL, "Alias"));
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code APP_GROUP}.
   *   <li>Then table return {@link ApplicationGroup}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'APP_GROUP'; then table return ApplicationGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenAppGroup_thenTableReturnApplicationGroup() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.APP_GROUP, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof ApplicationGroup);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code APP_GROUP}.
   *   <li>Then table return {@link ApplicationGroup}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'APP_GROUP'; then table return ApplicationGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenAppGroup_thenTableReturnApplicationGroup2() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.APP_GROUP, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof ApplicationGroup);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code APPLICATION}.
   *   <li>Then table return {@link Application}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'APPLICATION'; then table return Application")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenApplication_thenTableReturnApplication() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.APPLICATION, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof Application);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code APPLICATION}.
   *   <li>Then table return {@link Application}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'APPLICATION'; then table return Application")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenApplication_thenTableReturnApplication2() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.APPLICATION, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof Application);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_SET}.
   *   <li>Then table return {@link ChangeSet}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'CHANGE_SET'; then table return ChangeSet")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenChangeSet_thenTableReturnChangeSet() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.CHANGE_SET, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof ChangeSet);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_SET}.
   *   <li>Then table return {@link ChangeSet}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when 'CHANGE_SET'; then table return ChangeSet")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenChangeSet_thenTableReturnChangeSet2() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.CHANGE_SET, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof ChangeSet);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return table Schema is table.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when empty string; then return table Schema is table")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenEmptyString_thenReturnTableSchemaIsTable() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.ACTOR, "");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof Actor);
    assertEquals(tableResult, tableResult.getQualifiedName());
    assertEquals(tableResult, schema);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@code (UU)}.
   *   <li>Then table return {@link Actor}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind,
   * String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String); when '(UU)'; then table return Actor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFields_whenUu_thenTableReturnActor() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.ACTOR, "(UU)");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult instanceof Actor);
    assertEquals(tableResult, tableResult.getQualifiedName());
  }
}
