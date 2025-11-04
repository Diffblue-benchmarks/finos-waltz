package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.jooq.Field;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InlineSelectFieldFactoryDiffblueTest {
  /**
   * Method under test: {@link InlineSelectFieldFactory#mkNameField(Field, Field)}
   */
  @Test
  void testMkNameField() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    InlineSelectFieldFactory.mkNameField(FlowClassificationRuleDao.vantagePointId, kindCompareField);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)}
   */
  @Test
  void testMkNameField2() {
    // Arrange and Act
    Field<String> actualMkNameFieldResult = InlineSelectFieldFactory.mkNameField(
        FlowClassificationRuleDao.vantagePointId, PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkNameFieldResult);
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)}
   */
  @Test
  void testMkNameField3() {
    // Arrange
    Field<Long> idCompareField = mock(Field.class);

    // Act
    Field<String> actualMkNameFieldResult = InlineSelectFieldFactory.mkNameField(idCompareField,
        PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkNameFieldResult);
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)}
   */
  @Test
  void testMkNameField4() {
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
   * Method under test:
   * {@link InlineSelectFieldFactory#mkNameField(Field, Field, Collection)}
   */
  @Test
  void testMkNameField5() {
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
   * Method under test:
   * {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field)}
   */
  @Test
  void testMkDescriptionField() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    InlineSelectFieldFactory.mkDescriptionField(FlowClassificationRuleDao.vantagePointId, kindCompareField);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)}
   */
  @Test
  void testMkDescriptionField2() {
    // Arrange and Act
    Field<String> actualMkDescriptionFieldResult = InlineSelectFieldFactory.mkDescriptionField(
        FlowClassificationRuleDao.vantagePointId, PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkDescriptionFieldResult);
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)}
   */
  @Test
  void testMkDescriptionField3() {
    // Arrange
    Field<Long> idCompareField = mock(Field.class);

    // Act
    Field<String> actualMkDescriptionFieldResult = InlineSelectFieldFactory.mkDescriptionField(idCompareField,
        PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkDescriptionFieldResult);
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)}
   */
  @Test
  void testMkDescriptionField4() {
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
   * Method under test:
   * {@link InlineSelectFieldFactory#mkDescriptionField(Field, Field, Collection)}
   */
  @Test
  void testMkDescriptionField5() {
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
   * Method under test:
   * {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field)}
   */
  @Test
  void testMkExternalIdField() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    InlineSelectFieldFactory.mkExternalIdField(FlowClassificationRuleDao.vantagePointId, kindCompareField);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)}
   */
  @Test
  void testMkExternalIdField2() {
    // Arrange and Act
    Field<String> actualMkExternalIdFieldResult = InlineSelectFieldFactory.mkExternalIdField(
        FlowClassificationRuleDao.vantagePointId, PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkExternalIdFieldResult);
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)}
   */
  @Test
  void testMkExternalIdField3() {
    // Arrange
    Field<Long> idCompareField = mock(Field.class);

    // Act
    Field<String> actualMkExternalIdFieldResult = InlineSelectFieldFactory.mkExternalIdField(idCompareField,
        PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkExternalIdFieldResult);
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)}
   */
  @Test
  void testMkExternalIdField4() {
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
   * Method under test:
   * {@link InlineSelectFieldFactory#mkExternalIdField(Field, Field, Collection)}
   */
  @Test
  void testMkExternalIdField5() {
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
   * Method under test:
   * {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field)}
   */
  @Test
  void testMkEntityLifecycleField() {
    // Arrange
    Field<String> kindCompareField = mock(Field.class);
    when(kindCompareField.eq(Mockito.<Field<String>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    InlineSelectFieldFactory.mkEntityLifecycleField(FlowClassificationRuleDao.vantagePointId, kindCompareField);

    // Assert
    verify(kindCompareField, atLeast(1)).eq(Mockito.<Field<String>>any());
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)}
   */
  @Test
  void testMkEntityLifecycleField2() {
    // Arrange and Act
    Field<String> actualMkEntityLifecycleFieldResult = InlineSelectFieldFactory.mkEntityLifecycleField(
        FlowClassificationRuleDao.vantagePointId, PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkEntityLifecycleFieldResult);
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)}
   */
  @Test
  void testMkEntityLifecycleField3() {
    // Arrange
    Field<Long> idCompareField = mock(Field.class);

    // Act
    Field<String> actualMkEntityLifecycleFieldResult = InlineSelectFieldFactory.mkEntityLifecycleField(idCompareField,
        PhysicalSpecificationDao.owningEntityNameField, new ArrayList<>());

    // Assert
    assertNull(actualMkEntityLifecycleFieldResult);
  }

  /**
   * Method under test:
   * {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)}
   */
  @Test
  void testMkEntityLifecycleField4() {
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
   * Method under test:
   * {@link InlineSelectFieldFactory#mkEntityLifecycleField(Field, Field, Collection)}
   */
  @Test
  void testMkEntityLifecycleField5() {
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
}
