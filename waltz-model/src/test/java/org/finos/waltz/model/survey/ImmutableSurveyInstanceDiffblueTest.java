package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.survey.ImmutableSurveyInstance.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceDiffblueTest {
  /**
   * Test {@link ImmutableSurveyInstance#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstance#builder()}
   *   <li>{@link ImmutableSurveyInstance#approvedAt(LocalDateTime)}
   *   <li>{@link ImmutableSurveyInstance#approvedBy(String)}
   *   <li>{@link ImmutableSurveyInstance#kind(EntityKind)}
   *   <li>{@link ImmutableSurveyInstance#name(String)}
   *   <li>{@link ImmutableSurveyInstance#originalInstanceId(Long)}
   *   <li>{@link ImmutableSurveyInstance#owningRole(String)}
   *   <li>{@link ImmutableSurveyInstance#qualifierEntity(EntityReference)}
   *   <li>{@link ImmutableSurveyInstance#submittedAt(LocalDateTime)}
   *   <li>{@link ImmutableSurveyInstance#submittedBy(String)}
   *   <li>{@link ImmutableSurveyInstance#surveyEntityExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.approvedAt(LocalDateTime)", "Builder Builder.approvedBy(String)",
      "ImmutableSurveyInstance Builder.build()", "Builder Builder.issuedOn(LocalDate)",
      "Builder Builder.kind(EntityKind)", "Builder Builder.name(String)", "Builder Builder.originalInstanceId(Long)",
      "Builder Builder.owningRole(String)", "Builder Builder.qualifierEntity(EntityReference)",
      "Builder Builder.submittedAt(LocalDateTime)", "Builder Builder.submittedBy(String)",
      "Builder Builder.surveyEntityExternalId(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyInstance.builder();
    Builder actualIdResult = actualBuilderResult.approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .approvedBy("Approved By")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualQualifierEntityResult = actualIdResult.id(id)
        .kind(EntityKind.ALL)
        .name("Name")
        .originalInstanceId(1L)
        .owningRole("Owning Role")
        .qualifierEntity(null);
    Builder actualSubmittedByResult = actualQualifierEntityResult.submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .submittedBy("Submitted By");

    // Assert
    assertSame(actualSubmittedByResult, actualSubmittedByResult.surveyEntityExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#approvalDueDate(LocalDate)}.
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#approvalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder approvalDueDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.approvalDueDate(LocalDate)"})
  void testBuilderApprovalDueDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#dueDate(LocalDate)}.
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder dueDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dueDate(LocalDate)"})
  void testBuilderDueDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(mock(EntityReference.class));
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
    ImmutableSurveyInstance buildResult = actualFromResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    ImmutableSurveyInstance buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Approved By", buildResult2.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Name", buildResult2.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Owning Role", buildResult2.owningRole());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult2.originalInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link SurveyInstance} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'; given empty; when SurveyInstance id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance_givenEmpty_whenSurveyInstanceIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
    ImmutableSurveyInstance buildResult = actualFromResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    ImmutableSurveyInstance buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Approved By", buildResult2.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Name", buildResult2.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Owning Role", buildResult2.owningRole());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult2.originalInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <ul>
   *   <li>Then return build approvedBy is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'; then return build approvedBy is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance_thenReturnBuildApprovedByIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn(null);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
    ImmutableSurveyInstance buildResult = actualFromResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    ImmutableSurveyInstance buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.surveyEntityExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Name", buildResult2.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Owning Role", buildResult2.owningRole());
    assertNull(buildResult.approvedBy());
    assertNull(buildResult2.approvedBy());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult2.originalInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <ul>
   *   <li>Then return build name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'; then return build name is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance_thenReturnBuildNameIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn(null);
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
    ImmutableSurveyInstance buildResult = actualFromResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    ImmutableSurveyInstance buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Approved By", buildResult2.approvedBy());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Owning Role", buildResult2.owningRole());
    assertNull(buildResult.name());
    assertNull(buildResult2.name());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult2.originalInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <ul>
   *   <li>Then return build originalInstanceId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'; then return build originalInstanceId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance_thenReturnBuildOriginalInstanceIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(null);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
    ImmutableSurveyInstance buildResult = actualFromResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    ImmutableSurveyInstance buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Approved By", buildResult2.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Name", buildResult2.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Owning Role", buildResult2.owningRole());
    assertNull(buildResult.originalInstanceId());
    assertNull(buildResult2.originalInstanceId());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <ul>
   *   <li>Then return build owningRole is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'; then return build owningRole is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance_thenReturnBuildOwningRoleIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn(null);
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
    ImmutableSurveyInstance buildResult = actualFromResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    ImmutableSurveyInstance buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Approved By", buildResult2.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Name", buildResult2.name());
    assertNull(buildResult.owningRole());
    assertNull(buildResult2.owningRole());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult2.originalInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <ul>
   *   <li>Then return build surveyEntityExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'; then return build surveyEntityExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance_thenReturnBuildSurveyEntityExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
    ImmutableSurveyInstance buildResult = actualFromResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    ImmutableSurveyInstance buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Approved By", buildResult2.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Name", buildResult2.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Owning Role", buildResult2.owningRole());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult2.originalInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <ul>
   *   <li>Then return build surveyEntityExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'; then return build surveyEntityExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance_thenReturnBuildSurveyEntityExternalIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn(null);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
    ImmutableSurveyInstance buildResult = actualFromResult.build();
    assertEquals("Approved By", buildResult.approvedBy());
    ImmutableSurveyInstance buildResult2 = builderResult.build();
    assertEquals("Approved By", buildResult2.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Name", buildResult2.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Owning Role", buildResult2.owningRole());
    assertNull(buildResult.surveyEntityExternalId());
    assertNull(buildResult2.surveyEntityExternalId());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult2.originalInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).approvalDueDate();
    verify(instance).approvedAt();
    verify(instance).approvedBy();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).originalInstanceId();
    verify(instance).owningRole();
    verify(instance).qualifierEntity();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyEntity();
    verify(instance).surveyEntityExternalId();
    verify(instance).surveyRunId();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#status(SurveyInstanceStatus)}.
   * <p>
   * Method under test: {@link Builder#status(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName("Test Builder status(SurveyInstanceStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(SurveyInstanceStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Test Builder {@link Builder#surveyEntity(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#surveyEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder surveyEntity(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyEntity(EntityReference)"})
  void testBuilderSurveyEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyEntity(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#surveyRunId(Long)}.
   * <p>
   * Method under test: {@link Builder#surveyRunId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyRunId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyRunId(Long)"})
  void testBuilderSurveyRunId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRunId(1L));
  }

  /**
   * Test Json {@link Json#approvalDueDate()}.
   * <p>
   * Method under test: {@link Json#approvalDueDate()}
   */
  @Test
  @DisplayName("Test Json approvalDueDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.approvalDueDate()"})
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).approvalDueDate());
  }

  /**
   * Test Json {@link Json#approvedAt()}.
   * <p>
   * Method under test: {@link Json#approvedAt()}
   */
  @Test
  @DisplayName("Test Json approvedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.approvedAt()"})
  void testJsonApprovedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).approvedAt());
  }

  /**
   * Test Json {@link Json#approvedBy()}.
   * <p>
   * Method under test: {@link Json#approvedBy()}
   */
  @Test
  @DisplayName("Test Json approvedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.approvedBy()"})
  void testJsonApprovedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).approvedBy());
  }

  /**
   * Test Json {@link Json#dueDate()}.
   * <p>
   * Method under test: {@link Json#dueDate()}
   */
  @Test
  @DisplayName("Test Json dueDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.dueDate()"})
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dueDate());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#issuedOn()}.
   * <p>
   * Method under test: {@link Json#issuedOn()}
   */
  @Test
  @DisplayName("Test Json issuedOn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.issuedOn()"})
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).issuedOn());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.originalInstanceId);
    assertNull(actualJson.surveyRunId);
    assertNull(actualJson.approvedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.owningRole);
    assertNull(actualJson.submittedBy);
    assertNull(actualJson.surveyEntityExternalId);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.issuedOn);
    assertNull(actualJson.approvedAt);
    assertNull(actualJson.submittedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.qualifierEntity);
    assertNull(actualJson.surveyEntity);
    assertNull(actualJson.status);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#originalInstanceId()}.
   * <p>
   * Method under test: {@link Json#originalInstanceId()}
   */
  @Test
  @DisplayName("Test Json originalInstanceId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.originalInstanceId()"})
  void testJsonOriginalInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).originalInstanceId());
  }

  /**
   * Test Json {@link Json#owningRole()}.
   * <p>
   * Method under test: {@link Json#owningRole()}
   */
  @Test
  @DisplayName("Test Json owningRole()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.owningRole()"})
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).owningRole());
  }

  /**
   * Test Json {@link Json#qualifierEntity()}.
   * <p>
   * Method under test: {@link Json#qualifierEntity()}
   */
  @Test
  @DisplayName("Test Json qualifierEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.qualifierEntity()"})
  void testJsonQualifierEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).qualifierEntity());
  }

  /**
   * Test Json {@link Json#status()}.
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyInstanceStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }

  /**
   * Test Json {@link Json#submittedAt()}.
   * <p>
   * Method under test: {@link Json#submittedAt()}
   */
  @Test
  @DisplayName("Test Json submittedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.submittedAt()"})
  void testJsonSubmittedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).submittedAt());
  }

  /**
   * Test Json {@link Json#submittedBy()}.
   * <p>
   * Method under test: {@link Json#submittedBy()}
   */
  @Test
  @DisplayName("Test Json submittedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.submittedBy()"})
  void testJsonSubmittedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).submittedBy());
  }

  /**
   * Test Json {@link Json#surveyEntity()}.
   * <p>
   * Method under test: {@link Json#surveyEntity()}
   */
  @Test
  @DisplayName("Test Json surveyEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.surveyEntity()"})
  void testJsonSurveyEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyEntity());
  }

  /**
   * Test Json {@link Json#surveyEntityExternalId()}.
   * <p>
   * Method under test: {@link Json#surveyEntityExternalId()}
   */
  @Test
  @DisplayName("Test Json surveyEntityExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.surveyEntityExternalId()"})
  void testJsonSurveyEntityExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyEntityExternalId());
  }

  /**
   * Test Json {@link Json#surveyRunId()}.
   * <p>
   * Method under test: {@link Json#surveyRunId()}
   */
  @Test
  @DisplayName("Test Json surveyRunId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.surveyRunId()"})
  void testJsonSurveyRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyRunId());
  }
}
