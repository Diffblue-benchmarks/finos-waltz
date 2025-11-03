package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.jooq.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InlineSelectFieldFactoryDiffblueTest {
  /**
   * Test {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkNameField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkNameField(Field, Field, Collection)"})
  void testMkNameFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds() {
    // Arrange and Act
    Field<String> actualMkNameFieldResult = InlineSelectFieldFactory.mkNameField(
        FlowClassificationRuleDao.vantagePointId, PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkNameFieldResult);
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <ul>
   *   <li>Then calls {@link Field#eq(Field)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkNameField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'; then calls eq(Field)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkNameField(Field, Field, Collection)"})
  void testMkNameFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds_thenCallsEq() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<EntityKind> searchEntityKinds = new ArrayList<>();
    searchEntityKinds.add(EntityKind.ACTOR);
    searchEntityKinds.add(EntityKind.ACTOR);

    // Act
    InlineSelectFieldFactory.mkNameField(FlowClassificationRuleDao.vantagePointId, kindCompareField, searchEntityKinds);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(isA(Field.class));
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <ul>
   *   <li>Then calls {@link Field#eq(Field)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkNameField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'; then calls eq(Field)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkNameField(Field, Field, Collection)"})
  void testMkNameFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds_thenCallsEq2() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<EntityKind> searchEntityKinds = new ArrayList<>();
    searchEntityKinds.add(EntityKind.ACTOR);
    searchEntityKinds.add(EntityKind.APPLICATION);

    // Act
    InlineSelectFieldFactory.mkNameField(FlowClassificationRuleDao.vantagePointId, kindCompareField, searchEntityKinds);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkNameField(Field, Field)} with {@code idCompareField}, {@code kindCompareField}.
   * <ul>
   *   <li>Given {@link ApplicationDao#IS_ACTIVE}.</li>
   *   <li>Then calls {@link Field#eq(Field)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkNameField(Field, Field)}
   */
  @Test
  @DisplayName("Test mkNameField(Field, Field) with 'idCompareField', 'kindCompareField'; given IS_ACTIVE; then calls eq(Field)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkNameField(Field, Field)"})
  void testMkNameFieldWithIdCompareFieldKindCompareField_givenIs_active_thenCallsEq() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    InlineSelectFieldFactory.mkNameField(FlowClassificationRuleDao.vantagePointId, kindCompareField);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkDescriptionField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkDescriptionField(Field, Field, Collection)"})
  void testMkDescriptionFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds() {
    // Arrange and Act
    Field<String> actualMkDescriptionFieldResult = InlineSelectFieldFactory.mkDescriptionField(
        FlowClassificationRuleDao.vantagePointId, PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkDescriptionFieldResult);
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkDescriptionField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkDescriptionField(Field, Field, Collection)"})
  void testMkDescriptionFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds2() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<EntityKind> searchEntityKinds = new ArrayList<>();
    searchEntityKinds.add(EntityKind.ACTOR);
    searchEntityKinds.add(EntityKind.ACTOR);

    // Act
    InlineSelectFieldFactory.mkDescriptionField(FlowClassificationRuleDao.vantagePointId, kindCompareField,
        searchEntityKinds);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(isA(Field.class));
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkDescriptionField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkDescriptionField(Field, Field, Collection)"})
  void testMkDescriptionFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds3() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<EntityKind> searchEntityKinds = new ArrayList<>();
    searchEntityKinds.add(EntityKind.ACTOR);
    searchEntityKinds.add(EntityKind.APPLICATION);

    // Act
    InlineSelectFieldFactory.mkDescriptionField(FlowClassificationRuleDao.vantagePointId, kindCompareField,
        searchEntityKinds);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field)} with {@code idCompareField}, {@code kindCompareField}.
   * <ul>
   *   <li>Then calls {@link Field#eq(Field)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field)}
   */
  @Test
  @DisplayName("Test mkDescriptionField(Field, Field) with 'idCompareField', 'kindCompareField'; then calls eq(Field)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkDescriptionField(Field, Field)"})
  void testMkDescriptionFieldWithIdCompareFieldKindCompareField_thenCallsEq() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    InlineSelectFieldFactory.mkDescriptionField(FlowClassificationRuleDao.vantagePointId, kindCompareField);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkExternalIdField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkExternalIdField(Field, Field, Collection)"})
  void testMkExternalIdFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds() {
    // Arrange and Act
    Field<String> actualMkExternalIdFieldResult = InlineSelectFieldFactory.mkExternalIdField(
        FlowClassificationRuleDao.vantagePointId, PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkExternalIdFieldResult);
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkExternalIdField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkExternalIdField(Field, Field, Collection)"})
  void testMkExternalIdFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds2() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<EntityKind> searchEntityKinds = new ArrayList<>();
    searchEntityKinds.add(EntityKind.ACTOR);
    searchEntityKinds.add(EntityKind.ACTOR);

    // Act
    InlineSelectFieldFactory.mkExternalIdField(FlowClassificationRuleDao.vantagePointId, kindCompareField,
        searchEntityKinds);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(isA(Field.class));
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkExternalIdField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkExternalIdField(Field, Field, Collection)"})
  void testMkExternalIdFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds3() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<EntityKind> searchEntityKinds = new ArrayList<>();
    searchEntityKinds.add(EntityKind.ACTOR);
    searchEntityKinds.add(EntityKind.APPLICATION);

    // Act
    InlineSelectFieldFactory.mkExternalIdField(FlowClassificationRuleDao.vantagePointId, kindCompareField,
        searchEntityKinds);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field)} with {@code idCompareField}, {@code kindCompareField}.
   * <ul>
   *   <li>Then calls {@link Field#eq(Field)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field)}
   */
  @Test
  @DisplayName("Test mkExternalIdField(Field, Field) with 'idCompareField', 'kindCompareField'; then calls eq(Field)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkExternalIdField(Field, Field)"})
  void testMkExternalIdFieldWithIdCompareFieldKindCompareField_thenCallsEq() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    InlineSelectFieldFactory.mkExternalIdField(FlowClassificationRuleDao.vantagePointId, kindCompareField);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkEntityLifecycleField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkEntityLifecycleField(Field, Field, Collection)"})
  void testMkEntityLifecycleFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds() {
    // Arrange and Act
    Field<String> actualMkEntityLifecycleFieldResult = InlineSelectFieldFactory.mkEntityLifecycleField(
        FlowClassificationRuleDao.vantagePointId, PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkEntityLifecycleFieldResult);
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkEntityLifecycleField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkEntityLifecycleField(Field, Field, Collection)"})
  void testMkEntityLifecycleFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds2() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<EntityKind> searchEntityKinds = new ArrayList<>();
    searchEntityKinds.add(EntityKind.ACTOR);
    searchEntityKinds.add(EntityKind.ACTOR);

    // Act
    InlineSelectFieldFactory.mkEntityLifecycleField(FlowClassificationRuleDao.vantagePointId, kindCompareField,
        searchEntityKinds);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(isA(Field.class));
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)} with {@code idCompareField}, {@code kindCompareField}, {@code searchEntityKinds}.
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)}
   */
  @Test
  @DisplayName("Test mkEntityLifecycleField(Field, Field, Collection) with 'idCompareField', 'kindCompareField', 'searchEntityKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkEntityLifecycleField(Field, Field, Collection)"})
  void testMkEntityLifecycleFieldWithIdCompareFieldKindCompareFieldSearchEntityKinds3() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<EntityKind> searchEntityKinds = new ArrayList<>();
    searchEntityKinds.add(EntityKind.ACTOR);
    searchEntityKinds.add(EntityKind.APPLICATION);

    // Act
    InlineSelectFieldFactory.mkEntityLifecycleField(FlowClassificationRuleDao.vantagePointId, kindCompareField,
        searchEntityKinds);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Test {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field)} with {@code idCompareField}, {@code kindCompareField}.
   * <ul>
   *   <li>Then calls {@link Field#eq(Field)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field)}
   */
  @Test
  @DisplayName("Test mkEntityLifecycleField(Field, Field) with 'idCompareField', 'kindCompareField'; then calls eq(Field)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field InlineSelectFieldFactory.mkEntityLifecycleField(Field, Field)"})
  void testMkEntityLifecycleFieldWithIdCompareFieldKindCompareField_thenCallsEq() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    InlineSelectFieldFactory.mkEntityLifecycleField(FlowClassificationRuleDao.vantagePointId, kindCompareField);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }
}
