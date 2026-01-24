package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.Collection;
import java.util.Map;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.orgunit.search.OrganisationalUnitSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.AppRegistrationRequest;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableAppRegistrationRequest;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.tag.ImmutableTag;
import org.finos.waltz.model.tag.ImmutableTagUsage;
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

class AppGeneratorDiffblueTest {
  /**
   * Test {@link AppGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Then calls {@link TagDao#removeTagUsage(EntityReference, String)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); then calls removeTagUsage(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AppGenerator.create(ApplicationContext)"})
  void testCreate_thenCallsRemoveTagUsage() throws BeansException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();

    ApplicationDao appDao = mock(ApplicationDao.class);

    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any()))
        .thenReturn(
            messageResult
                .originalRequest(
                    ImmutableAppRegistrationRequest.builder()
                        .applicationKind(ApplicationKind.IN_HOUSE)
                        .assetCode("Asset Code")
                        .businessCriticality(Criticality.LOW)
                        .description("The characteristics of someone or something")
                        .lifecyclePhase(LifecyclePhase.PRODUCTION)
                        .name("Name")
                        .organisationalUnitId(1L)
                        .overallRating(RagRating.R)
                        .parentAssetCode("Parent Asset Code")
                        .provenance("Provenance")
                        .build())
                .build());

    ArrayList<org.finos.waltz.model.tag.Tag> tagList = new ArrayList<>();
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());

    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
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

    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, entityAliasDao, mock(ApplicationSearchDao.class));

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
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));
    when(ctx.getBean(ApplicationService.class)).thenReturn(applicationService);
    when(ctx.getBean(OrganisationalUnitService.class)).thenReturn(organisationalUnitService);

    // Act
    Map<String, Integer> actualCreateResult = appGenerator.create(ctx);

    // Assert
    verify(appDao, atLeast(1)).registerApp(Mockito.<AppRegistrationRequest>any());
    verify(entityAliasDao, atLeast(1))
        .updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(dao).findAll();
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(tagDao, atLeast(1)).removeTagUsage(isA(EntityReference.class), eq("Name"));
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link AppGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Then calls {@link TagDao#removeTagUsage(EntityReference, String)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); then calls removeTagUsage(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AppGenerator.create(ApplicationContext)"})
  void testCreate_thenCallsRemoveTagUsage2() throws BeansException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();

    ApplicationDao appDao = mock(ApplicationDao.class);

    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any()))
        .thenReturn(
            messageResult
                .originalRequest(
                    ImmutableAppRegistrationRequest.builder()
                        .applicationKind(ApplicationKind.IN_HOUSE)
                        .assetCode("Asset Code")
                        .businessCriticality(Criticality.LOW)
                        .description("The characteristics of someone or something")
                        .lifecyclePhase(LifecyclePhase.PRODUCTION)
                        .name("Name")
                        .organisationalUnitId(1L)
                        .overallRating(RagRating.R)
                        .parentAssetCode("Parent Asset Code")
                        .provenance("Provenance")
                        .build())
                .build());

    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult.addTagUsages(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag =
        builderResult.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ArrayList<org.finos.waltz.model.tag.Tag> tagList = new ArrayList<>();
    tagList.add(immutableTag);

    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
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

    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, entityAliasDao, mock(ApplicationSearchDao.class));

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
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));
    when(ctx.getBean(ApplicationService.class)).thenReturn(applicationService);
    when(ctx.getBean(OrganisationalUnitService.class)).thenReturn(organisationalUnitService);

    // Act
    Map<String, Integer> actualCreateResult = appGenerator.create(ctx);

    // Assert
    verify(appDao, atLeast(1)).registerApp(Mockito.<AppRegistrationRequest>any());
    verify(entityAliasDao, atLeast(1))
        .updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(dao).findAll();
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(tagDao, atLeast(1)).removeTagUsage(isA(EntityReference.class), eq("Name"));
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link AppGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AppGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName("Test create(ApplicationContext); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AppGenerator.create(ApplicationContext)"})
  void testCreate_thenReturnNull() throws BeansException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();

    ApplicationDao appDao = mock(ApplicationDao.class);

    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any()))
        .thenReturn(
            messageResult
                .originalRequest(
                    ImmutableAppRegistrationRequest.builder()
                        .applicationKind(ApplicationKind.IN_HOUSE)
                        .assetCode("Asset Code")
                        .businessCriticality(Criticality.LOW)
                        .description("The characteristics of someone or something")
                        .lifecyclePhase(LifecyclePhase.PRODUCTION)
                        .name("Name")
                        .organisationalUnitId(1L)
                        .overallRating(RagRating.R)
                        .parentAssetCode("Parent Asset Code")
                        .provenance("Provenance")
                        .build())
                .build());

    TagDao tagDao = mock(TagDao.class);
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
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

    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, entityAliasDao, mock(ApplicationSearchDao.class));

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
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));
    when(ctx.getBean(ApplicationService.class)).thenReturn(applicationService);
    when(ctx.getBean(OrganisationalUnitService.class)).thenReturn(organisationalUnitService);

    // Act
    Map<String, Integer> actualCreateResult = appGenerator.create(ctx);

    // Assert
    verify(appDao, atLeast(1)).registerApp(Mockito.<AppRegistrationRequest>any());
    verify(entityAliasDao, atLeast(1))
        .updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(dao).findAll();
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link AppGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenReturnTrue()
      throws SQLException, BeansException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(DSLContext.class))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = appGenerator.remove(ctx);

    // Assert
    verify(connection).prepareStatement("delete from \"application\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
