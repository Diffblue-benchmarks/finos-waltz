package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
import java.util.Optional;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_rating.SaveAssessmentRatingCommand;
import org.finos.waltz.schema.tables.records.AssessmentDefinitionRecord;
import org.finos.waltz.schema.tables.records.AssessmentRatingRecord;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertReturningStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class AssessmentHelperDiffblueTest {
  @InjectMocks
  private AssessmentHelper assessmentHelper;

  @Mock
  private DSLContext dSLContext;

  @Mock
  private AssessmentRatingService assessmentRatingService;

  @Mock
  private AssessmentDefinitionService assessmentDefinitionService;

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroup() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "Definition Group");

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroup2() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "", AssessmentVisibility.PRIMARY,
        "Definition Group");

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroup3() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "");

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroup4() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", null,
        AssessmentVisibility.PRIMARY, null);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}, {@code entityKind}, {@code cardinality}, {@code qualifierRef}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup', 'entityKind', 'cardinality', 'qualifierRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroupEntityKindCardinalityQualifierRef() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    Optional<EntityReference> qualifierRef = Optional.of(mock(EntityReference.class));

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "Definition Group", EntityKind.ALL, Cardinality.ZERO_ONE, qualifierRef);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}, {@code entityKind}, {@code cardinality}, {@code qualifierRef}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup', 'entityKind', 'cardinality', 'qualifierRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroupEntityKindCardinalityQualifierRef2() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    Optional<EntityReference> qualifierRef = Optional.of(mock(EntityReference.class));

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "", AssessmentVisibility.PRIMARY,
        "Definition Group", EntityKind.ALL, Cardinality.ZERO_ONE, qualifierRef);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}, {@code entityKind}, {@code cardinality}, {@code qualifierRef}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup', 'entityKind', 'cardinality', 'qualifierRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroupEntityKindCardinalityQualifierRef3() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    Optional<EntityReference> qualifierRef = Optional.of(mock(EntityReference.class));

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "", EntityKind.ALL, Cardinality.ZERO_ONE, qualifierRef);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}, {@code entityKind}, {@code cardinality}, {@code qualifierRef}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup', 'entityKind', 'cardinality', 'qualifierRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroupEntityKindCardinalityQualifierRef4() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    Optional<EntityReference> qualifierRef = Optional.of(mock(EntityReference.class));

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", null,
        AssessmentVisibility.PRIMARY, null, EntityKind.ALL, Cardinality.ZERO_ONE, qualifierRef);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}, {@code entityKind}, {@code qualifierRef}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup', 'entityKind', 'qualifierRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroupEntityKindQualifierRef() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "Definition Group", EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}, {@code entityKind}, {@code qualifierRef}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup', 'entityKind', 'qualifierRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroupEntityKindQualifierRef2() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "", AssessmentVisibility.PRIMARY,
        "Definition Group", EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}, {@code entityKind}, {@code qualifierRef}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup', 'entityKind', 'qualifierRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroupEntityKindQualifierRef3() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "", EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)} with {@code schemeId}, {@code name}, {@code permittedRole}, {@code visibility}, {@code definitionGroup}, {@code entityKind}, {@code qualifierRef}.
   * <p>
   * Method under test: {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)}
   */
  @Test
  @DisplayName("Test createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference) with 'schemeId', 'name', 'permittedRole', 'visibility', 'definitionGroup', 'entityKind', 'qualifierRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "long AssessmentHelper.createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)"})
  void testCreateDefinitionWithSchemeIdNamePermittedRoleVisibilityDefinitionGroupEntityKindQualifierRef4() {
    // Arrange
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", null,
        AssessmentVisibility.PRIMARY, null, EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Test {@link AssessmentHelper#createAssessment(Long, EntityReference, Long, String)} with {@code defId}, {@code ref}, {@code ratingId}, {@code username}.
   * <p>
   * Method under test: {@link AssessmentHelper#createAssessment(Long, EntityReference, Long, String)}
   */
  @Test
  @DisplayName("Test createAssessment(Long, EntityReference, Long, String) with 'defId', 'ref', 'ratingId', 'username'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssessmentHelper.createAssessment(Long, EntityReference, Long, String)"})
  void testCreateAssessmentWithDefIdRefRatingIdUsername() throws InsufficientPrivelegeException {
    // Arrange
    when(assessmentRatingService.store(Mockito.<SaveAssessmentRatingCommand>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    assessmentHelper.createAssessment(1L, mock(EntityReference.class), 1L, "janedoe");

    // Assert
    verify(assessmentRatingService).store(isA(SaveAssessmentRatingCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentHelper#createAssessment(Long, EntityReference, Long, String)} with {@code defId}, {@code ref}, {@code ratingId}, {@code username}.
   * <p>
   * Method under test: {@link AssessmentHelper#createAssessment(Long, EntityReference, Long, String)}
   */
  @Test
  @DisplayName("Test createAssessment(Long, EntityReference, Long, String) with 'defId', 'ref', 'ratingId', 'username'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssessmentHelper.createAssessment(Long, EntityReference, Long, String)"})
  void testCreateAssessmentWithDefIdRefRatingIdUsername2() throws InsufficientPrivelegeException {
    // Arrange
    when(assessmentRatingService.store(Mockito.<SaveAssessmentRatingCommand>any(), Mockito.<String>any()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> assessmentHelper.createAssessment(1L, mock(EntityReference.class), 1L, "janedoe"));
    verify(assessmentRatingService).store(isA(SaveAssessmentRatingCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentHelper#createAssessment(Long, EntityReference, Long)} with {@code defId}, {@code ref}, {@code ratingId}.
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentHelper#createAssessment(Long, EntityReference, Long)}
   */
  @Test
  @DisplayName("Test createAssessment(Long, EntityReference, Long) with 'defId', 'ref', 'ratingId'; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssessmentHelper.createAssessment(Long, EntityReference, Long)"})
  void testCreateAssessmentWithDefIdRefRatingId_thenCallsId() throws DataAccessException {
    // Arrange
    AssessmentRatingRecord assessmentRatingRecord = mock(AssessmentRatingRecord.class);
    doNothing().when(assessmentRatingRecord).setDescription(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setEntityKind(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setIsReadonly(Mockito.<Boolean>any());
    doNothing().when(assessmentRatingRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(assessmentRatingRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setProvenance(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setRatingId(Mockito.<Long>any());
    doNothing().when(assessmentRatingRecord).setEntityId(Mockito.<Long>any());
    doNothing().when(assessmentRatingRecord).setAssessmentDefinitionId(Mockito.<Long>any());
    InsertReturningStep<AssessmentRatingRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(1);
    InsertSetMoreStep<AssessmentRatingRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetStep<AssessmentRatingRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(insertSetStep);
    when(dSLContext.newRecord(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(assessmentRatingRecord);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    assessmentHelper.createAssessment(1L, ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(assessmentRatingRecord).setAssessmentDefinitionId(eq(1L));
    verify(assessmentRatingRecord).setDescription(eq("test"));
    verify(assessmentRatingRecord).setEntityId(eq(1L));
    verify(assessmentRatingRecord).setEntityKind(eq("ALL"));
    verify(assessmentRatingRecord).setIsReadonly(eq(false));
    verify(assessmentRatingRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(assessmentRatingRecord).setLastUpdatedBy(eq("test"));
    verify(assessmentRatingRecord).setProvenance(eq("test"));
    verify(assessmentRatingRecord).setRatingId(eq(1L));
    verify(dSLContext).insertInto(isA(Table.class));
    verify(dSLContext).newRecord(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetStep).set(isA(Record.class));
    verify(insertReturningStep).execute();
  }

  /**
   * Test {@link AssessmentHelper#updateDefinitionReadOnly(long)}.
   * <p>
   * Method under test: {@link AssessmentHelper#updateDefinitionReadOnly(long)}
   */
  @Test
  @DisplayName("Test updateDefinitionReadOnly(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssessmentHelper.updateDefinitionReadOnly(long)"})
  void testUpdateDefinitionReadOnly() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentDefinitionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AssessmentDefinitionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AssessmentDefinitionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentDefinitionRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    assessmentHelper.updateDefinitionReadOnly(1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentHelper#updateRatingReadOnly(EntityReference, long)}.
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link Query#execute()} return one.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentHelper#updateRatingReadOnly(EntityReference, long)}
   */
  @Test
  @DisplayName("Test updateRatingReadOnly(EntityReference, long); given UpdateConditionStep execute() return one; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssessmentHelper.updateRatingReadOnly(EntityReference, long)"})
  void testUpdateRatingReadOnly_givenUpdateConditionStepExecuteReturnOne_thenCallsId() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    assessmentHelper.updateRatingReadOnly(ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentHelper#setDefExtId(long, String)}.
   * <p>
   * Method under test: {@link AssessmentHelper#setDefExtId(long, String)}
   */
  @Test
  @DisplayName("Test setDefExtId(long, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssessmentHelper.setDefExtId(long, String)"})
  void testSetDefExtId() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentDefinitionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AssessmentDefinitionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AssessmentDefinitionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentDefinitionRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    assessmentHelper.setDefExtId(1L, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }
}
