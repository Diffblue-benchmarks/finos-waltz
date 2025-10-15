package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.CopySurveyResponsesCommand;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Builder;
import org.finos.waltz.model.survey.SurveyInstanceQuestionResponse;
import org.finos.waltz.schema.tables.records.SurveyQuestionResponseRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TransactionalCallable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyQuestionResponseDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyQuestionResponseDao surveyQuestionResponseDao;

  /**
   * Test {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}.
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName("Test deletePreviousResponse(Optional, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyQuestionResponseRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyQuestionResponseRecord>>any()))
        .thenReturn(deleteUsingStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    ArrayList<SurveyInstanceQuestionResponse> previousResponses = new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    previousResponses.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(2L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);
    previousResponses.add(
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    previousResponses.addAll(new ArrayList<>());

    // Act
    int actualDeletePreviousResponseResult =
        surveyQuestionResponseDao.deletePreviousResponse(tx, previousResponses);

    // Assert
    verify(dSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(deleteConditionStep2, atLeast(1)).and(Mockito.<Condition>any());
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep, atLeast(1)).execute();
    assertEquals(2, actualDeletePreviousResponseResult);
  }

  /**
   * Test {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}.
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName("Test deletePreviousResponse(Optional, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse2() throws SQLException {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao =
        new SurveyQuestionResponseDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    ArrayList<SurveyInstanceQuestionResponse> previousResponses = new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    previousResponses.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    // Act
    int actualDeletePreviousResponseResult =
        surveyQuestionResponseDao.deletePreviousResponse(tx, previousResponses);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualDeletePreviousResponseResult);
  }

  /**
   * Test {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}.
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName("Test deletePreviousResponse(Optional, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse3() throws SQLException {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao =
        new SurveyQuestionResponseDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    ArrayList<SurveyInstanceQuestionResponse> previousResponses = new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    previousResponses.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    // Act
    int actualDeletePreviousResponseResult =
        surveyQuestionResponseDao.deletePreviousResponse(tx, previousResponses);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualDeletePreviousResponseResult);
  }

  /**
   * Test {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName("Test deletePreviousResponse(Optional, List); given ArrayList(); then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse_givenArrayList_thenReturnTwo() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyQuestionResponseRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyQuestionResponseRecord>>any()))
        .thenReturn(deleteUsingStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    ArrayList<SurveyInstanceQuestionResponse> previousResponses = new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    previousResponses.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);
    previousResponses.add(
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    previousResponses.addAll(new ArrayList<>());

    // Act
    int actualDeletePreviousResponseResult =
        surveyQuestionResponseDao.deletePreviousResponse(tx, previousResponses);

    // Assert
    verify(dSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(deleteConditionStep2, atLeast(1)).and(Mockito.<Condition>any());
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep, atLeast(1)).execute();
    assertEquals(2, actualDeletePreviousResponseResult);
  }

  /**
   * Test {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName(
      "Test deletePreviousResponse(Optional, List); given DSLContext; when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse_givenDSLContext_whenArrayList_thenReturnZero() {
    // Arrange
    Optional<DSLContext> tx = Optional.of(dSLContext);

    // Act and Assert
    assertEquals(0, surveyQuestionResponseDao.deletePreviousResponse(tx, new ArrayList<>()));
  }

  /**
   * Test {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName("Test deletePreviousResponse(Optional, List); then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse_thenReturnTwo() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyQuestionResponseRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyQuestionResponseRecord>>any()))
        .thenReturn(deleteUsingStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    ArrayList<SurveyInstanceQuestionResponse> previousResponses = new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    previousResponses.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    // Act
    int actualDeletePreviousResponseResult =
        surveyQuestionResponseDao.deletePreviousResponse(tx, previousResponses);

    // Assert
    verify(dSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(deleteConditionStep2, atLeast(1)).and(Mockito.<Condition>any());
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep, atLeast(1)).execute();
    assertEquals(2, actualDeletePreviousResponseResult);
  }

  /**
   * Test {@link SurveyQuestionResponseDao#copyResponses(Long, CopySurveyResponsesCommand, Long)}.
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#copyResponses(Long,
   * CopySurveyResponsesCommand, Long)}
   */
  @Test
  @DisplayName("Test copyResponses(Long, CopySurveyResponsesCommand, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyQuestionResponseDao.copyResponses(Long, CopySurveyResponsesCommand, Long)"
  })
  void testCopyResponses() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualCopyResponsesResult = surveyQuestionResponseDao.copyResponses(1L, null, 1L);

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualCopyResponsesResult);
  }
}
