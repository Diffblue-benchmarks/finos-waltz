package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.jooq.Catalog;
import org.jooq.Schema;
import org.jooq.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommonTableFieldsRegistryDiffblueTest {
  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.ASSESSMENT_DEFINITION, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof AssessmentDefinition);
    assertEquals(141, schema.getTables().size());
    assertEquals(2, tableResult.getKeys().size());
    assertEquals(schema, catalog);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>Then return table Schema {@link DefaultSchema#ALLOCATION_SCHEME} is table.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); then return table Schema ALLOCATION_SCHEME is table")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_thenReturnTableSchemaAllocation_schemeIsTable() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.ALLOCATION_SCHEME, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof AllocationScheme);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(schema, catalog);
    assertSame(tableResult, ((DefaultSchema) schema).ALLOCATION_SCHEME);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>Then return table Schema {@link DefaultSchema#APPLICATION} is table.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); then return table Schema APPLICATION is table")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_thenReturnTableSchemaApplicationIsTable() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.APPLICATION, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof Application);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(schema, catalog);
    assertSame(tableResult, ((DefaultSchema) schema).APPLICATION);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>Then return table Schema {@link DefaultSchema#APPLICATION_GROUP} is table.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); then return table Schema APPLICATION_GROUP is table")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_thenReturnTableSchemaApplication_groupIsTable() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.APP_GROUP, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof ApplicationGroup);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(schema, catalog);
    assertSame(tableResult, ((DefaultSchema) schema).APPLICATION_GROUP);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>Then return table Schema {@link DefaultSchema#CHANGE_INITIATIVE} is table.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); then return table Schema CHANGE_INITIATIVE is table")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_thenReturnTableSchemaChange_initiativeIsTable() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.CHANGE_INITIATIVE, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeInitiative);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(schema, catalog);
    assertSame(tableResult, ((DefaultSchema) schema).CHANGE_INITIATIVE);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>Then table return {@link AllocationScheme}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); then table return AllocationScheme")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_thenTableReturnAllocationScheme() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.ALLOCATION_SCHEME, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof AllocationScheme);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(schema, catalog);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>Then table return {@link AssessmentDefinition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); then table return AssessmentDefinition")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_thenTableReturnAssessmentDefinition() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.ASSESSMENT_DEFINITION, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    assertTrue(actualDetermineCommonTableFieldsResult.table() instanceof AssessmentDefinition);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>Then table return {@link ChangeInitiative}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); then table return ChangeInitiative")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_thenTableReturnChangeInitiative() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.CHANGE_INITIATIVE, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeInitiative);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(schema, catalog);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>When {@code ACTOR}.</li>
   *   <li>Then return table Schema {@link DefaultSchema#ACTOR} is table.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); when 'ACTOR'; then return table Schema ACTOR is table")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_whenActor_thenReturnTableSchemaActorIsTable() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.ACTOR, null);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof Actor);
    assertEquals(3, tableResult.getKeys().size());
    assertEquals(schema, catalog);
    assertSame(tableResult, ((DefaultSchema) schema).ACTOR);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>When {@code ACTOR}.</li>
   *   <li>Then table return {@link Actor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); when 'ACTOR'; then table return Actor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_whenActor_thenTableReturnActor() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.ACTOR, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof Actor);
    assertEquals(3, tableResult.getKeys().size());
    assertEquals(schema, catalog);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>When {@code ALL}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); when 'ALL'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_whenAll_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> CommonTableFieldsRegistry.determineCommonTableFields(EntityKind.ALL, "Alias"));
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>When {@code APP_GROUP}.</li>
   *   <li>Then table return {@link ApplicationGroup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); when 'APP_GROUP'; then table return ApplicationGroup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_whenAppGroup_thenTableReturnApplicationGroup() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.APP_GROUP, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof ApplicationGroup);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(schema, catalog);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>When {@code APPLICATION}.</li>
   *   <li>Then table return {@link Application}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); when 'APPLICATION'; then table return Application")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_whenApplication_thenTableReturnApplication() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.APPLICATION, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof Application);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(schema, catalog);
  }

  /**
   * Test {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}.
   * <ul>
   *   <li>When {@code (U)}.</li>
   *   <li>Then table return {@link Actor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonTableFieldsRegistry#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String); when '(U)'; then table return Actor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields CommonTableFieldsRegistry.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFields_whenU_thenTableReturnActor() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = CommonTableFieldsRegistry
        .determineCommonTableFields(EntityKind.ACTOR, "(U)");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    Schema schema = tableResult.getSchema();
    Catalog catalog = schema.getCatalog();
    assertTrue(catalog instanceof DefaultCatalog);
    assertTrue(schema instanceof DefaultSchema);
    assertTrue(tableResult instanceof Actor);
    assertEquals(3, tableResult.getKeys().size());
    assertEquals(schema, catalog);
  }
}
