package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.attestation.ImmutableLatestMeasurableAttestationInfo.Builder;
import org.finos.waltz.model.attestation.ImmutableLatestMeasurableAttestationInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLatestMeasurableAttestationInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#attestationInstanceRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#attestationInstanceRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder attestationInstanceRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestationInstanceRef(EntityReference)"})
  void testBuilderAttestationInstanceRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act
    Builder actualAttestationInstanceRefResult =
        builderResult.attestationInstanceRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAttestationInstanceRefResult);
  }

  /**
   * Test Builder {@link Builder#attestationRunRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#attestationRunRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder attestationRunRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestationRunRef(EntityReference)"})
  void testBuilderAttestationRunRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act
    Builder actualAttestationRunRefResult =
        builderResult.attestationRunRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAttestationRunRefResult);
  }

  /**
   * Test Builder {@link Builder#categoryRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#categoryRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder categoryRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.categoryRef(EntityReference)"})
  void testBuilderCategoryRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act
    Builder actualCategoryRefResult =
        builderResult.categoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualCategoryRefResult);
  }

  /**
   * Test Builder {@link Builder#dueDate(Date)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dueDate(Date)}
   */
  @Test
  @DisplayName("Test Builder dueDate(Date); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dueDate(Date)"})
  void testBuilderDueDate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act
    Builder actualDueDateResult =
        builderResult.dueDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(builderResult, actualDueDateResult);
  }

  /**
   * Test Builder {@link Builder#from(LatestMeasurableAttestationInfo)}.
   *
   * <p>Method under test: {@link Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  @DisplayName("Test Builder from(LatestMeasurableAttestationInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LatestMeasurableAttestationInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.attestationInstanceRef()).thenThrow(new IllegalStateException());
    when(instance.categoryRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationInstanceRef();
    verify(instance).categoryRef();
  }

  /**
   * Test Builder {@link Builder#from(LatestMeasurableAttestationInfo)}.
   *
   * <p>Method under test: {@link Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  @DisplayName("Test Builder from(LatestMeasurableAttestationInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LatestMeasurableAttestationInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.attestationRunRef()).thenThrow(new IllegalStateException());
    when(instance.attestationInstanceRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.categoryRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).categoryRef();
  }

  /**
   * Test Builder {@link Builder#from(LatestMeasurableAttestationInfo)}.
   *
   * <p>Method under test: {@link Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  @DisplayName("Test Builder from(LatestMeasurableAttestationInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LatestMeasurableAttestationInfo)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.attestedAt()).thenThrow(new IllegalStateException());
    when(instance.attestationRunRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.attestationInstanceRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.categoryRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).categoryRef();
  }

  /**
   * Test Builder {@link Builder#from(LatestMeasurableAttestationInfo)}.
   *
   * <p>Method under test: {@link Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  @DisplayName("Test Builder from(LatestMeasurableAttestationInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LatestMeasurableAttestationInfo)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.issuedOn()).thenThrow(new IllegalStateException());
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(null);
    when(instance.dueDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.attestationRunRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.attestationInstanceRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.categoryRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).categoryRef();
    verify(instance).dueDate();
    verify(instance).issuedOn();
  }

  /**
   * Test Builder {@link Builder#from(LatestMeasurableAttestationInfo)}.
   *
   * <ul>
   *   <li>Then builder build attestedAt is {@link Timestamp#Timestamp(long)} with time is ten.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LatestMeasurableAttestationInfo); then builder build attestedAt is Timestamp(long) with time is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LatestMeasurableAttestationInfo)"})
  void testBuilderFrom_thenBuilderBuildAttestedAtIsTimestampWithTimeIsTen() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.issuedOn())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.attestedBy()).thenReturn("Attested By");
    Timestamp timestamp = new Timestamp(10L);
    when(instance.attestedAt()).thenReturn(timestamp);
    when(instance.dueDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.attestationRunRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.attestationInstanceRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.categoryRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).categoryRef();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    assertEquals("Attested By", actualFromResult.build().attestedBy());
    ImmutableLatestMeasurableAttestationInfo immutableLatestMeasurableAttestationInfo =
        builderResult.build();
    assertEquals("Attested By", immutableLatestMeasurableAttestationInfo.attestedBy());
    assertSame(timestamp, immutableLatestMeasurableAttestationInfo.attestedAt());
  }

  /**
   * Test Builder {@link Builder#from(LatestMeasurableAttestationInfo)}.
   *
   * <ul>
   *   <li>Then return build attestedBy is {@code Attested By}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LatestMeasurableAttestationInfo); then return build attestedBy is 'Attested By'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LatestMeasurableAttestationInfo)"})
  void testBuilderFrom_thenReturnBuildAttestedByIsAttestedBy() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.issuedOn())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(null);
    when(instance.dueDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.attestationRunRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.attestationInstanceRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.categoryRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).categoryRef();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    ImmutableLatestMeasurableAttestationInfo immutableLatestMeasurableAttestationInfo =
        actualFromResult.build();
    assertEquals("Attested By", immutableLatestMeasurableAttestationInfo.attestedBy());
    ImmutableLatestMeasurableAttestationInfo immutableLatestMeasurableAttestationInfo2 =
        builderResult.build();
    assertEquals("Attested By", immutableLatestMeasurableAttestationInfo2.attestedBy());
    assertNull(immutableLatestMeasurableAttestationInfo.attestedAt());
    assertNull(immutableLatestMeasurableAttestationInfo2.attestedAt());
  }

  /**
   * Test Builder {@link Builder#from(LatestMeasurableAttestationInfo)}.
   *
   * <ul>
   *   <li>Then return build attestedBy is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LatestMeasurableAttestationInfo); then return build attestedBy is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LatestMeasurableAttestationInfo)"})
  void testBuilderFrom_thenReturnBuildAttestedByIsNull() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.issuedOn())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.attestedBy()).thenReturn(null);
    when(instance.attestedAt()).thenReturn(null);
    when(instance.dueDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.attestationRunRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.attestationInstanceRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(instance.categoryRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).categoryRef();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    ImmutableLatestMeasurableAttestationInfo immutableLatestMeasurableAttestationInfo =
        actualFromResult.build();
    assertNull(immutableLatestMeasurableAttestationInfo.attestedBy());
    ImmutableLatestMeasurableAttestationInfo immutableLatestMeasurableAttestationInfo2 =
        builderResult.build();
    assertNull(immutableLatestMeasurableAttestationInfo2.attestedBy());
    assertNull(immutableLatestMeasurableAttestationInfo.attestedAt());
    assertNull(immutableLatestMeasurableAttestationInfo2.attestedAt());
  }

  /**
   * Test Builder {@link Builder#issuedOn(Date)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#issuedOn(Date)}
   */
  @Test
  @DisplayName("Test Builder issuedOn(Date); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.issuedOn(Date)"})
  void testBuilderIssuedOn_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act
    Builder actualIssuedOnResult =
        builderResult.issuedOn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(builderResult, actualIssuedOnResult);
  }

  /**
   * Test Json {@link Json#attestationInstanceRef()}.
   *
   * <p>Method under test: {@link Json#attestationInstanceRef()}
   */
  @Test
  @DisplayName("Test Json attestationInstanceRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.attestationInstanceRef()"})
  void testJsonAttestationInstanceRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestationInstanceRef());
  }

  /**
   * Test Json {@link Json#attestationRunRef()}.
   *
   * <p>Method under test: {@link Json#attestationRunRef()}
   */
  @Test
  @DisplayName("Test Json attestationRunRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.attestationRunRef()"})
  void testJsonAttestationRunRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestationRunRef());
  }

  /**
   * Test Json {@link Json#attestedAt()}.
   *
   * <p>Method under test: {@link Json#attestedAt()}
   */
  @Test
  @DisplayName("Test Json attestedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timestamp Json.attestedAt()"})
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedAt());
  }

  /**
   * Test Json {@link Json#attestedBy()}.
   *
   * <p>Method under test: {@link Json#attestedBy()}
   */
  @Test
  @DisplayName("Test Json attestedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.attestedBy()"})
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedBy());
  }

  /**
   * Test Json {@link Json#categoryRef()}.
   *
   * <p>Method under test: {@link Json#categoryRef()}
   */
  @Test
  @DisplayName("Test Json categoryRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.categoryRef()"})
  void testJsonCategoryRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().categoryRef());
  }

  /**
   * Test Json {@link Json#dueDate()}.
   *
   * <p>Method under test: {@link Json#dueDate()}
   */
  @Test
  @DisplayName("Test Json dueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.dueDate()"})
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dueDate());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAttestationInstanceRef(EntityReference)}
   *   <li>{@link Json#setAttestationRunRef(EntityReference)}
   *   <li>{@link Json#setAttestedBy(String)}
   *   <li>{@link Json#setCategoryRef(EntityReference)}
   *   <li>{@link Json#setDueDate(Date)}
   *   <li>{@link Json#setIssuedOn(Date)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAttestationInstanceRef(EntityReference)",
    "void Json.setAttestationRunRef(EntityReference)",
    "void Json.setAttestedAt(Timestamp)",
    "void Json.setAttestedBy(String)",
    "void Json.setCategoryRef(EntityReference)",
    "void Json.setDueDate(Date)",
    "void Json.setIssuedOn(Date)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    ImmutableEntityReference attestationInstanceRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    actualJson.setAttestationInstanceRef(attestationInstanceRef);
    actualJson.setAttestationRunRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setAttestedBy("Attested By");
    actualJson.setCategoryRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setDueDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualJson.setIssuedOn(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    EntityReference entityReference = actualJson.attestationInstanceRef;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    EntityReference entityReference2 = actualJson.attestationRunRef;
    assertTrue(entityReference2 instanceof ImmutableEntityReference);
    EntityReference entityReference3 = actualJson.categoryRef;
    assertTrue(entityReference3 instanceof ImmutableEntityReference);
    assertEquals("Attested By", actualJson.attestedBy);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertNull(actualJson.attestedAt);
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(attestationInstanceRef, entityReference2);
    assertEquals(attestationInstanceRef, entityReference3);
  }

  /**
   * Test Json {@link Json#issuedOn()}.
   *
   * <p>Method under test: {@link Json#issuedOn()}
   */
  @Test
  @DisplayName("Test Json issuedOn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.issuedOn()"})
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().issuedOn());
  }
}
