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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
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
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TransactionalCallable;
import org.jooq.TransactionalRunnable;
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
  void testDeletePreviousResponse() throws SQLException {
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
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName("Test deletePreviousResponse(Optional, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse3() throws DataAccessException {
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
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName("Test deletePreviousResponse(Optional, List); then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse_thenCallsDeleteFrom() throws DataAccessException {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao =
        new SurveyQuestionResponseDao(new DefaultDSLContext(SQLDialect.SQL99));

    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyQuestionResponseRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<SurveyQuestionResponseRecord>>any()))
        .thenReturn(deleteUsingStep);
    Optional<DSLContext> tx = Optional.of(defaultDSLContext);

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
    verify(deleteConditionStep2, atLeast(1)).and(Mockito.<Condition>any());
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep, atLeast(1)).execute();
    verify(defaultDSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    assertEquals(2, actualDeletePreviousResponseResult);
  }

  /**
   * Test {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName("Test deletePreviousResponse(Optional, List); then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse_thenCallsDeleteFrom2() throws DataAccessException {
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
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  @DisplayName(
      "Test deletePreviousResponse(Optional, List); when of DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionResponseDao.deletePreviousResponse(Optional, List)"})
  void testDeletePreviousResponse_whenOfDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao =
        new SurveyQuestionResponseDao(new DefaultDSLContext(SQLDialect.SQL99));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, surveyQuestionResponseDao.deletePreviousResponse(tx, new ArrayList<>()));
  }

  /**
   * Test {@link SurveyQuestionResponseDao#saveResponse(SurveyInstanceQuestionResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceQuestionResponse#lastUpdatedAt()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyQuestionResponseDao#saveResponse(SurveyInstanceQuestionResponse)}
   */
  @Test
  @DisplayName("Test saveResponse(SurveyInstanceQuestionResponse); then calls lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionResponseDao.saveResponse(SurveyInstanceQuestionResponse)"})
  void testSaveResponse_thenCallsLastUpdatedAt() throws DataAccessException {
    // Arrange
    SurveyQuestionResponseRecord surveyQuestionResponseRecord =
        mock(SurveyQuestionResponseRecord.class);
    doNothing().when(surveyQuestionResponseRecord).setBooleanResponse(Mockito.<Boolean>any());
    doNothing().when(surveyQuestionResponseRecord).setComment(Mockito.<String>any());
    doNothing().when(surveyQuestionResponseRecord).setDateResponse(Mockito.<Date>any());
    doNothing().when(surveyQuestionResponseRecord).setEntityResponseId(Mockito.<Long>any());
    doNothing().when(surveyQuestionResponseRecord).setEntityResponseKind(Mockito.<String>any());
    doNothing().when(surveyQuestionResponseRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(surveyQuestionResponseRecord).setListResponseConcat(Mockito.<String>any());
    doNothing().when(surveyQuestionResponseRecord).setNumberResponse(Mockito.<BigDecimal>any());
    doNothing().when(surveyQuestionResponseRecord).setPersonId(Mockito.<Long>any());
    doNothing().when(surveyQuestionResponseRecord).setQuestionId(Mockito.<Long>any());
    doNothing().when(surveyQuestionResponseRecord).setStringResponse(Mockito.<String>any());
    doNothing().when(surveyQuestionResponseRecord).setSurveyInstanceId(Mockito.<Long>any());

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(true);

    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    when(dsl.newRecord(Mockito.<Table<SurveyQuestionResponseRecord>>any()))
        .thenReturn(surveyQuestionResponseRecord);
    SurveyQuestionResponseDao surveyQuestionResponseDao = new SurveyQuestionResponseDao(dsl);

    SurveyInstanceQuestionResponse response = mock(SurveyInstanceQuestionResponse.class);
    when(response.personId()).thenReturn(1L);
    when(response.surveyInstanceId()).thenReturn(1L);
    when(response.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

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
    when(response.questionResponse())
        .thenReturn(
            entityResponseResult
                .listResponse(new ArrayList<>())
                .numberResponse(10.0d)
                .questionId(1L)
                .stringResponse("String Response")
                .build());

    // Act
    surveyQuestionResponseDao.saveResponse(response);

    // Assert
    verify(response).lastUpdatedAt();
    verify(response).personId();
    verify(response, atLeast(1)).questionResponse();
    verify(response, atLeast(1)).surveyInstanceId();
    verify(surveyQuestionResponseRecord).setBooleanResponse(true);
    verify(surveyQuestionResponseRecord).setComment("Comment");
    verify(surveyQuestionResponseRecord).setDateResponse(isA(Date.class));
    verify(surveyQuestionResponseRecord).setEntityResponseId(1L);
    verify(surveyQuestionResponseRecord).setEntityResponseKind("ALL");
    verify(surveyQuestionResponseRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(surveyQuestionResponseRecord).setListResponseConcat(null);
    verify(surveyQuestionResponseRecord).setNumberResponse(isA(BigDecimal.class));
    verify(surveyQuestionResponseRecord).setPersonId(1L);
    verify(surveyQuestionResponseRecord).setQuestionId(1L);
    verify(surveyQuestionResponseRecord).setStringResponse("String Response");
    verify(surveyQuestionResponseRecord).setSurveyInstanceId(1L);
    verify(dsl).newRecord(isA(Table.class));
    verify(dsl).select(isA(SelectField.class));
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
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
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualCopyResponsesResult = new SurveyQuestionResponseDao(dsl).copyResponses(1L, null, 1L);

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualCopyResponsesResult);
  }
}
