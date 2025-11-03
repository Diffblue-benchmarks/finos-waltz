package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.application.AppRegistrationRequest;
import org.finos.waltz.model.application.AppRegistrationResponse;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.service.application.ApplicationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class AppHelperDiffblueTest {
  @InjectMocks
  private AppHelper appHelper;

  @Mock
  private ApplicationService applicationService;

  /**
   * Test {@link AppHelper#createNewApp(String, Long, String)} with {@code name}, {@code ouId}, {@code assetCode}.
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#createNewApp(String, Long, String)}
   */
  @Test
  @DisplayName("Test createNewApp(String, Long, String) with 'name', 'ouId', 'assetCode'; then return ImmutableEntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference AppHelper.createNewApp(String, Long, String)"})
  void testCreateNewAppWithNameOuIdAssetCode_thenReturnImmutableEntityReference() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appRegistrationResponse.id()).thenReturn(ofResult);
    when(applicationService.registerApp(Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
        .thenReturn(appRegistrationResponse);

    // Act
    EntityReference actualCreateNewAppResult = appHelper.createNewApp("Name", 1L, "Asset Code");

    // Assert
    verify(appRegistrationResponse).id();
    verify(applicationService).registerApp(isA(AppRegistrationRequest.class), eq("appHelper"));
    assertTrue(actualCreateNewAppResult instanceof ImmutableEntityReference);
    assertNull(actualCreateNewAppResult.description());
    assertEquals(1L, actualCreateNewAppResult.id());
    assertEquals(EntityKind.APPLICATION, actualCreateNewAppResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCreateNewAppResult.entityLifecycleStatus());
  }

  /**
   * Test {@link AppHelper#createNewApp(String, Long)} with {@code name}, {@code ouId}.
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#createNewApp(String, Long)}
   */
  @Test
  @DisplayName("Test createNewApp(String, Long) with 'name', 'ouId'; then return ImmutableEntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference AppHelper.createNewApp(String, Long)"})
  void testCreateNewAppWithNameOuId_thenReturnImmutableEntityReference() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appRegistrationResponse.id()).thenReturn(ofResult);
    when(applicationService.registerApp(Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
        .thenReturn(appRegistrationResponse);

    // Act
    EntityReference actualCreateNewAppResult = appHelper.createNewApp("Name", 1L);

    // Assert
    verify(appRegistrationResponse).id();
    verify(applicationService).registerApp(isA(AppRegistrationRequest.class), eq("appHelper"));
    assertTrue(actualCreateNewAppResult instanceof ImmutableEntityReference);
    assertNull(actualCreateNewAppResult.description());
    assertEquals(1L, actualCreateNewAppResult.id());
    assertEquals(EntityKind.APPLICATION, actualCreateNewAppResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCreateNewAppResult.entityLifecycleStatus());
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link Application#actualRetirementDate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application actualRetirementDate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationActualRetirementDateReturnEmpty() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.plannedRetirementDate()).thenReturn(ofResult3);
    when(application.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(application.actualRetirementDate()).thenReturn(emptyResult);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult4);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult5);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link Application#assetCode()} return empty.</li>
   *   <li>Then calls {@link DescriptionProvider#description()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application assetCode() return empty; then calls description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationAssetCodeReturnEmpty_thenCallsDescription() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.plannedRetirementDate()).thenReturn(ofResult3);
    when(application.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.actualRetirementDate()).thenReturn(ofResult4);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> emptyResult = Optional.empty();
    when(application.assetCode()).thenReturn(emptyResult);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult5);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link Application#commissionDate()} return empty.</li>
   *   <li>Then calls {@link DescriptionProvider#description()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application commissionDate() return empty; then calls description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationCommissionDateReturnEmpty_thenCallsDescription() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(application.commissionDate()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.plannedRetirementDate()).thenReturn(ofResult2);
    when(application.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.actualRetirementDate()).thenReturn(ofResult3);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult4);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult5);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link EntityLifecycleStatusProvider#entityLifecycleStatus()} return {@code REMOVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application entityLifecycleStatus() return 'REMOVED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationEntityLifecycleStatusReturnRemoved() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.plannedRetirementDate()).thenReturn(ofResult3);
    when(application.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.actualRetirementDate()).thenReturn(ofResult4);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult5);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult6);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.REMOVED);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link IdProvider#id()} return empty.</li>
   *   <li>Then calls {@link DescriptionProvider#description()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application id() return empty; then calls description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationIdReturnEmpty_thenCallsDescription() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(application.id()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.commissionDate()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.plannedRetirementDate()).thenReturn(ofResult2);
    when(application.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.actualRetirementDate()).thenReturn(ofResult3);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult4);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult5);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link IdProvider#id()} return {@link Optional} with one.</li>
   *   <li>Then calls {@link DescriptionProvider#description()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application id() return Optional with one; then calls description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationIdReturnOptionalWithOne_thenCallsDescription() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.plannedRetirementDate()).thenReturn(ofResult3);
    when(application.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.actualRetirementDate()).thenReturn(ofResult4);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult5);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult6);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link IsRemovedProvider#isRemoved()} return {@code false}.</li>
   *   <li>Then calls {@link DescriptionProvider#description()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application isRemoved() return 'false'; then calls description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationIsRemovedReturnFalse_thenCallsDescription() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.plannedRetirementDate()).thenReturn(ofResult3);
    when(application.isRemoved()).thenReturn(false);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.actualRetirementDate()).thenReturn(ofResult4);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult5);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult6);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link Application#parentAssetCode()} return empty.</li>
   *   <li>Then calls {@link DescriptionProvider#description()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application parentAssetCode() return empty; then calls description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationParentAssetCodeReturnEmpty_thenCallsDescription() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.plannedRetirementDate()).thenReturn(ofResult3);
    when(application.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.actualRetirementDate()).thenReturn(ofResult4);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult5);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> emptyResult = Optional.empty();
    when(application.parentAssetCode()).thenReturn(emptyResult);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   * <ul>
   *   <li>Given {@link Application} {@link Application#plannedRetirementDate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long); given Application plannedRetirementDate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp_givenApplicationPlannedRetirementDateReturnEmpty() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(application.plannedRetirementDate()).thenReturn(emptyResult);
    when(application.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(application.actualRetirementDate()).thenReturn(ofResult3);
    when(application.kind()).thenReturn(EntityKind.ALL);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult4);
    when(application.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult5);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.provenance()).thenReturn("Provenance");
    when(application.name()).thenReturn("Name");
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(application).description();
    verify(application).entityLifecycleStatus();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).actualRetirementDate();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).commissionDate();
    verify(application).kind();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).plannedRetirementDate();
    verify(application).provenance();
    verify(applicationService).getById(eq(1L));
    verify(applicationService).update(isA(Application.class));
  }
}
