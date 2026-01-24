package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.util.Map;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.orgunit.search.OrganisationalUnitSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRule.Builder;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.orgunit.OrganisationalUnitService;
import org.finos.waltz.service.tag.TagService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

class LogicalFlowGeneratorDiffblueTest {
  /**
   * Test {@link LogicalFlowGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao} {@link ApplicationDao#findAll()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given ApplicationDao findAll() return ArrayList(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LogicalFlowGenerator.create(ApplicationContext)"})
  void testCreate_givenApplicationDaoFindAllReturnArrayList_thenReturnNull() throws BeansException {
    // Arrange
    LogicalFlowGenerator logicalFlowGenerator = new LogicalFlowGenerator();

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findAll()).thenReturn(new ArrayList<>());
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    when(dao.findAll()).thenReturn(new ArrayList<>());
    OrganisationalUnitService organisationalUnitService =
        new OrganisationalUnitService(dao, mock(OrganisationalUnitSearchDao.class));

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(FlowClassificationRuleDao.class)).thenReturn(flowClassificationRuleDao);
    when(ctx.getBean(ApplicationService.class)).thenReturn(applicationService);
    when(ctx.getBean(OrganisationalUnitService.class)).thenReturn(organisationalUnitService);
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    Map<String, Integer> actualCreateResult = logicalFlowGenerator.create(ctx);

    // Assert
    verify(appDao).findAll();
    verify(flowClassificationRuleDao).findByEntityKind(EntityKind.ORG_UNIT);
    verify(dao).findAll();
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link LogicalFlowGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName("Test create(ApplicationContext); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LogicalFlowGenerator.create(ApplicationContext)"})
  void testCreate_thenReturnNull() throws BeansException {
    // Arrange
    LogicalFlowGenerator logicalFlowGenerator = new LogicalFlowGenerator();

    ArrayList<FlowClassificationRule> flowClassificationRuleList = new ArrayList<>();

    Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleList.add(
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(flowClassificationRuleList);

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findAll()).thenReturn(new ArrayList<>());
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    organisationalUnitList.add(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    when(dao.findAll()).thenReturn(organisationalUnitList);
    OrganisationalUnitService organisationalUnitService =
        new OrganisationalUnitService(dao, mock(OrganisationalUnitSearchDao.class));

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(FlowClassificationRuleDao.class)).thenReturn(flowClassificationRuleDao);
    when(ctx.getBean(ApplicationService.class)).thenReturn(applicationService);
    when(ctx.getBean(OrganisationalUnitService.class)).thenReturn(organisationalUnitService);
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    Map<String, Integer> actualCreateResult = logicalFlowGenerator.create(ctx);

    // Assert
    verify(appDao).findAll();
    verify(flowClassificationRuleDao).findByEntityKind(EntityKind.ORG_UNIT);
    verify(dao).findAll();
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link LogicalFlowGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName("Test create(ApplicationContext); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LogicalFlowGenerator.create(ApplicationContext)"})
  void testCreate_thenReturnNull2() throws BeansException {
    // Arrange
    LogicalFlowGenerator logicalFlowGenerator = new LogicalFlowGenerator();

    ArrayList<FlowClassificationRule> flowClassificationRuleList = new ArrayList<>();

    Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleList.add(
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    Builder provenanceResult2 =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    Builder subjectOrgUnitReferenceResult2 =
        provenanceResult2.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder subjectReferenceResult2 =
        subjectOrgUnitReferenceResult2.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleList.add(
        subjectReferenceResult2
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(flowClassificationRuleList);

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findAll()).thenReturn(new ArrayList<>());
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    organisationalUnitList.add(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    when(dao.findAll()).thenReturn(organisationalUnitList);
    OrganisationalUnitService organisationalUnitService =
        new OrganisationalUnitService(dao, mock(OrganisationalUnitSearchDao.class));

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(FlowClassificationRuleDao.class)).thenReturn(flowClassificationRuleDao);
    when(ctx.getBean(ApplicationService.class)).thenReturn(applicationService);
    when(ctx.getBean(OrganisationalUnitService.class)).thenReturn(organisationalUnitService);
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    Map<String, Integer> actualCreateResult = logicalFlowGenerator.create(ctx);

    // Assert
    verify(appDao).findAll();
    verify(flowClassificationRuleDao).findByEntityKind(EntityKind.ORG_UNIT);
    verify(dao).findAll();
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link LogicalFlowGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenReturnTrue()
      throws SQLException, BeansException {
    // Arrange
    LogicalFlowGenerator logicalFlowGenerator = new LogicalFlowGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(DSLContext.class))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = logicalFlowGenerator.remove(ctx);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"logical_flow\" where \"logical_flow\".\"provenance\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "waltz-sample");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
