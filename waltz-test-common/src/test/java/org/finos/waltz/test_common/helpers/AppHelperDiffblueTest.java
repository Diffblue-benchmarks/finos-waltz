package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.AppRegistrationRequest;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableAppRegistrationRequest;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse.Builder;
import org.finos.waltz.model.application.ImmutableApplication;
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
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppHelperDiffblueTest {
  @InjectMocks private AppHelper appHelper;

  @Mock private ApplicationService applicationService;

  /**
   * Test {@link AppHelper#createNewApp(String, Long, String)} with {@code name}, {@code ouId},
   * {@code assetCode}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link AppHelper#createNewApp(String, Long, String)}
   */
  @Test
  @DisplayName(
      "Test createNewApp(String, Long, String) with 'name', 'ouId', 'assetCode'; then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference AppHelper.createNewApp(String, Long, String)"})
  void testCreateNewAppWithNameOuIdAssetCode_thenReturnImmutableEntityReference() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(applicationService.registerApp(
            Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
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

    // Act
    EntityReference actualCreateNewAppResult = appHelper.createNewApp("Name", 1L, "Asset Code");

    // Assert
    verify(applicationService).registerApp(isA(AppRegistrationRequest.class), eq("appHelper"));
    assertTrue(actualCreateNewAppResult instanceof ImmutableEntityReference);
    assertNull(actualCreateNewAppResult.description());
    assertEquals(1L, actualCreateNewAppResult.id());
    assertEquals(EntityKind.APPLICATION, actualCreateNewAppResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCreateNewAppResult.entityLifecycleStatus());
  }

  /**
   * Test {@link AppHelper#createNewApp(String, Long, String)} with {@code name}, {@code ouId},
   * {@code assetCode}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link AppHelper#createNewApp(String, Long, String)}
   */
  @Test
  @DisplayName(
      "Test createNewApp(String, Long, String) with 'name', 'ouId', 'assetCode'; then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference AppHelper.createNewApp(String, Long, String)"})
  void testCreateNewAppWithNameOuIdAssetCode_thenReturnImmutableEntityReference2() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(applicationService.registerApp(
            Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
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

    // Act
    EntityReference actualCreateNewAppResult = appHelper.createNewApp("Name", null, "Asset Code");

    // Assert
    verify(applicationService).registerApp(isA(AppRegistrationRequest.class), eq("appHelper"));
    assertTrue(actualCreateNewAppResult instanceof ImmutableEntityReference);
    assertNull(actualCreateNewAppResult.description());
    assertEquals(1L, actualCreateNewAppResult.id());
    assertEquals(EntityKind.APPLICATION, actualCreateNewAppResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCreateNewAppResult.entityLifecycleStatus());
  }

  /**
   * Test {@link AppHelper#createNewApp(String, Long)} with {@code name}, {@code ouId}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link AppHelper#createNewApp(String, Long)}
   */
  @Test
  @DisplayName(
      "Test createNewApp(String, Long) with 'name', 'ouId'; when 'Name'; then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference AppHelper.createNewApp(String, Long)"})
  void testCreateNewAppWithNameOuId_whenName_thenReturnImmutableEntityReference() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(applicationService.registerApp(
            Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
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

    // Act
    EntityReference actualCreateNewAppResult = appHelper.createNewApp("Name", 1L);

    // Assert
    verify(applicationService).registerApp(isA(AppRegistrationRequest.class), eq("appHelper"));
    assertTrue(actualCreateNewAppResult instanceof ImmutableEntityReference);
    assertNull(actualCreateNewAppResult.description());
    assertEquals(1L, actualCreateNewAppResult.id());
    assertEquals(EntityKind.APPLICATION, actualCreateNewAppResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCreateNewAppResult.entityLifecycleStatus());
  }

  /**
   * Test {@link AppHelper#createNewApp(String, Long)} with {@code name}, {@code ouId}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link AppHelper#createNewApp(String, Long)}
   */
  @Test
  @DisplayName(
      "Test createNewApp(String, Long) with 'name', 'ouId'; when 'Name'; then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference AppHelper.createNewApp(String, Long)"})
  void testCreateNewAppWithNameOuId_whenName_thenReturnImmutableEntityReference2() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(applicationService.registerApp(
            Mockito.<AppRegistrationRequest>any(), Mockito.<String>any()))
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

    // Act
    EntityReference actualCreateNewAppResult = appHelper.createNewApp("Name", null);

    // Assert
    verify(applicationService).registerApp(isA(AppRegistrationRequest.class), eq("appHelper"));
    assertTrue(actualCreateNewAppResult instanceof ImmutableEntityReference);
    assertNull(actualCreateNewAppResult.description());
    assertEquals(1L, actualCreateNewAppResult.id());
    assertEquals(EntityKind.APPLICATION, actualCreateNewAppResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCreateNewAppResult.entityLifecycleStatus());
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   *
   * <p>Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp() {
    // Arrange
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationService.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(applicationService).getById(1L);
    verify(applicationService).update(isA(Application.class));
  }

  /**
   * Test {@link AppHelper#removeApp(Long)}.
   *
   * <p>Method under test: {@link AppHelper#removeApp(Long)}
   */
  @Test
  @DisplayName("Test removeApp(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppHelper.removeApp(Long)"})
  void testRemoveApp2() {
    // Arrange
    when(applicationService.update(Mockito.<Application>any())).thenReturn(1);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.REMOVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationService.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Act
    appHelper.removeApp(1L);

    // Assert
    verify(applicationService).getById(1L);
    verify(applicationService).update(isA(Application.class));
  }
}
