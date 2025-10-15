package org.finos.waltz.data.attestation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.jooq.CommonTableExpression;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Select;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.WithStep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class AttestationPreCheckDaoDiffblueTest {
  @InjectMocks private AttestationPreCheckDao attestationPreCheckDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks() {
    // Arrange
    when(dSLContext.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks2() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks3() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks4() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks5() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks6() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks7() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks8() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks9() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    WithStep withStep8 = mock(WithStep.class);
    when(withStep8.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep8);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep8).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks10() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    WithStep withStep8 = mock(WithStep.class);
    when(withStep8.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep8);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep8).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks11() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.union(Mockito.<Select<Record>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    WithStep withStep8 = mock(WithStep.class);
    when(withStep8.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep8);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).union(isA(Select.class));
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep8).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks12() {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.union(Mockito.<Select<Record>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    WithStep withStep8 = mock(WithStep.class);
    when(withStep8.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep8);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).union(isA(Select.class));
    verify(selectOrderByStep).union(isA(Select.class));
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep8).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks13() {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.union(Mockito.<Select<Record>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOrderByStep<Record> selectOrderByStep2 = mock(SelectOrderByStep.class);
    when(selectOrderByStep2.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    WithStep withStep8 = mock(WithStep.class);
    when(withStep8.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep8);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).union(isA(Select.class));
    verify(selectOrderByStep2).union(isA(Select.class));
    verify(selectOrderByStep).union(isA(Select.class));
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep8).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks14() {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.union(Mockito.<Select<Record>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOrderByStep<Record> selectOrderByStep2 = mock(SelectOrderByStep.class);
    when(selectOrderByStep2.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectOrderByStep<Record> selectOrderByStep3 = mock(SelectOrderByStep.class);
    when(selectOrderByStep3.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    WithStep withStep8 = mock(WithStep.class);
    when(withStep8.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep8);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).union(isA(Select.class));
    verify(selectOrderByStep3).union(isA(Select.class));
    verify(selectOrderByStep2).union(isA(Select.class));
    verify(selectOrderByStep).union(isA(Select.class));
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep8).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowAttestationPreChecks(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks15() {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.union(Mockito.<Select<Record>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOrderByStep<Record> selectOrderByStep2 = mock(SelectOrderByStep.class);
    when(selectOrderByStep2.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectOrderByStep<Record> selectOrderByStep3 = mock(SelectOrderByStep.class);
    when(selectOrderByStep3.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep2);

    SelectOrderByStep<Record> selectOrderByStep4 = mock(SelectOrderByStep.class);
    when(selectOrderByStep4.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep4);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    WithStep withStep8 = mock(WithStep.class);
    when(withStep8.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep8);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).union(isA(Select.class));
    verify(selectOrderByStep4).union(isA(Select.class));
    verify(selectOrderByStep3).union(isA(Select.class));
    verify(selectOrderByStep2).union(isA(Select.class));
    verify(selectOrderByStep).union(isA(Select.class));
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep8).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectOrderByStep#forEach(Consumer)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationPreCheckDao#calcLogicalFlowAttestationPreChecks(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test calcLogicalFlowAttestationPreChecks(EntityReference); then calls forEach(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks AttestationPreCheckDao.calcLogicalFlowAttestationPreChecks(EntityReference)"
  })
  void testCalcLogicalFlowAttestationPreChecks_thenCallsForEach() {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    doThrow(new IllegalArgumentException())
        .when(selectOrderByStep)
        .forEach(Mockito.<Consumer<Record>>any());

    SelectOrderByStep<Record> selectOrderByStep2 = mock(SelectOrderByStep.class);
    when(selectOrderByStep2.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectOrderByStep<Record> selectOrderByStep3 = mock(SelectOrderByStep.class);
    when(selectOrderByStep3.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep2);

    SelectOrderByStep<Record> selectOrderByStep4 = mock(SelectOrderByStep.class);
    when(selectOrderByStep4.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep3);

    SelectOrderByStep<Record> selectOrderByStep5 = mock(SelectOrderByStep.class);
    when(selectOrderByStep5.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep5);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    WithStep withStep3 = mock(WithStep.class);
    when(withStep3.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    WithStep withStep4 = mock(WithStep.class);
    when(withStep4.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep3);

    WithStep withStep5 = mock(WithStep.class);
    when(withStep5.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep4);

    WithStep withStep6 = mock(WithStep.class);
    when(withStep6.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep5);

    WithStep withStep7 = mock(WithStep.class);
    when(withStep7.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep6);

    WithStep withStep8 = mock(WithStep.class);
    when(withStep8.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep7);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep8);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectOrderByStep).forEach(isA(Consumer.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).union(isA(Select.class));
    verify(selectOrderByStep5).union(isA(Select.class));
    verify(selectOrderByStep4).union(isA(Select.class));
    verify(selectOrderByStep3).union(isA(Select.class));
    verify(selectOrderByStep2).union(isA(Select.class));
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep8).with((CommonTableExpression[]) Mockito.any());
    verify(withStep7).with((CommonTableExpression[]) Mockito.any());
    verify(withStep6).with((CommonTableExpression[]) Mockito.any());
    verify(withStep5).with((CommonTableExpression[]) Mockito.any());
    verify(withStep4).with((CommonTableExpression[]) Mockito.any());
    verify(withStep3).with((CommonTableExpression[]) Mockito.any());
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
  }
}
