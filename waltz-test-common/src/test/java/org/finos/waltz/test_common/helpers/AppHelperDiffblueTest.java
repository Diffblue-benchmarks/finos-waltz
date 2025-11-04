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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.AppRegistrationRequest;
import org.finos.waltz.model.application.AppRegistrationResponse;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.service.application.ApplicationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class AppHelperDiffblueTest {
  /**
   * Method under test: {@link AppHelper#createNewApp(String, Long)}
   */
  @Test
  void testCreateNewApp() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appRegistrationResponse.id()).thenReturn(ofResult);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.registerApp(Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
        .thenReturn(appRegistrationResponse);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#createNewApp(String, Long)}
   */
  @Test
  void testCreateNewApp2() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appRegistrationResponse.id()).thenReturn(ofResult);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.registerApp(Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
        .thenReturn(appRegistrationResponse);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

    // Act
    EntityReference actualCreateNewAppResult = appHelper.createNewApp("Name", null);

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
   * Method under test: {@link AppHelper#createNewApp(String, Long, String)}
   */
  @Test
  void testCreateNewApp3() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appRegistrationResponse.id()).thenReturn(ofResult);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.registerApp(Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
        .thenReturn(appRegistrationResponse);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#createNewApp(String, Long, String)}
   */
  @Test
  void testCreateNewApp4() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appRegistrationResponse.id()).thenReturn(ofResult);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.registerApp(Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
        .thenReturn(appRegistrationResponse);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

    // Act
    EntityReference actualCreateNewAppResult = appHelper.createNewApp("Name", null, "Asset Code");

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp2() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp3() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp4() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp5() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp6() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp7() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp8() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
   * Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  void testRemoveApp9() {
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
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);
    when(applicationService.getById(anyLong())).thenReturn(application);
    AppHelper appHelper = new AppHelper();
    ReflectionTestUtils.setField(appHelper, "applicationSvc", applicationService);

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
