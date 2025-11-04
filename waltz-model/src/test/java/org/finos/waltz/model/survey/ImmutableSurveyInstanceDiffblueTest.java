package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyInstance.Builder actualBuilderResult = ImmutableSurveyInstance.builder();
    ImmutableSurveyInstance.Builder actualIdResult = actualBuilderResult
        .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .approvedBy("Approved By")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableSurveyInstance.Builder actualQualifierEntityResult = actualIdResult.id(id)
        .kind(EntityKind.ALL)
        .name("Name")
        .originalInstanceId(1L)
        .owningRole("Owning Role")
        .qualifierEntity(null);
    ImmutableSurveyInstance.Builder actualSubmittedByResult = actualQualifierEntityResult
        .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .submittedBy("Submitted By");

    // Assert
    assertSame(actualSubmittedByResult, actualSubmittedByResult.surveyEntityExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#approvalDueDate(LocalDate)}
   */
  @Test
  void testBuilderApprovalDueDate() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#approvalDueDate(LocalDate)}
   */
  @Test
  void testBuilderApprovalDueDate2() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate2() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyInstance buildResult = builderResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult4, buildResult.dueDate());
    assertSame(ofResult3, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
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
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyInstance buildResult = builderResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult, buildResult.approvalDueDate());
    assertSame(ofResult3, buildResult.dueDate());
    assertSame(ofResult2, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn(null);
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyInstance buildResult = builderResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertNull(buildResult.name());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult4, buildResult.dueDate());
    assertSame(ofResult3, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn(null);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyInstance buildResult = builderResult.build();
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertNull(buildResult.surveyEntityExternalId());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult4, buildResult.dueDate());
    assertSame(ofResult3, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(mock(EntityReference.class));
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyInstance buildResult = builderResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult4, buildResult.dueDate());
    assertSame(ofResult3, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.originalInstanceId()).thenReturn(null);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyInstance buildResult = builderResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertNull(buildResult.originalInstanceId());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult4, buildResult.dueDate());
    assertSame(ofResult3, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn(null);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyInstance buildResult = builderResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertNull(buildResult.approvedBy());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult4, buildResult.dueDate());
    assertSame(ofResult3, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#from(SurveyInstance)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn(null);
    when(instance.approvedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyInstance buildResult = builderResult.build();
    assertEquals("42", buildResult.surveyEntityExternalId());
    assertEquals("Approved By", buildResult.approvedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertNull(buildResult.owningRole());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1L, buildResult.originalInstanceId().longValue());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult4, buildResult.dueDate());
    assertSame(ofResult3, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#status(SurveyInstanceStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#status(SurveyInstanceStatus)}
   */
  @Test
  void testBuilderStatus2() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.status(SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Builder#surveyEntity(EntityReference)}
   */
  @Test
  void testBuilderSurveyEntity() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyEntity(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#surveyRunId(Long)}
   */
  @Test
  void testBuilderSurveyRunId() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRunId(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Builder#surveyRunId(Long)}
   */
  @Test
  void testBuilderSurveyRunId2() {
    // Arrange
    ImmutableSurveyInstance.Builder builderResult = ImmutableSurveyInstance.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRunId(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult3);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult4.atStartOfDay());
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, approvalDueDateResult);
    assertSame(ofResult6, dueDateResult);
    assertSame(ofResult5, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult3.atStartOfDay());
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult4);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult, toLocalDateResult2);
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult5, dueDateResult);
    assertSame(ofResult4, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn(null);
    when(instance.surveyEntityExternalId()).thenReturn("42");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult3);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult4.atStartOfDay());
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertNull(actualCopyOfResult.name());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, approvalDueDateResult);
    assertSame(ofResult6, dueDateResult);
    assertSame(ofResult5, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn(null);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult3);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult4.atStartOfDay());
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertNull(actualCopyOfResult.surveyEntityExternalId());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, approvalDueDateResult);
    assertSame(ofResult6, dueDateResult);
    assertSame(ofResult5, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(mock(EntityReference.class));
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult3);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult4.atStartOfDay());
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, approvalDueDateResult);
    assertSame(ofResult6, dueDateResult);
    assertSame(ofResult5, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult3);
    when(instance.originalInstanceId()).thenReturn(null);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult4.atStartOfDay());
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertNull(actualCopyOfResult.originalInstanceId());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, approvalDueDateResult);
    assertSame(ofResult6, dueDateResult);
    assertSame(ofResult5, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult3);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn(null);
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult4.atStartOfDay());
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertNull(actualCopyOfResult.approvedBy());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, approvalDueDateResult);
    assertSame(ofResult6, dueDateResult);
    assertSame(ofResult5, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult3);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn(null);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult4.atStartOfDay());
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn("Submitted By");
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertNull(actualCopyOfResult.owningRole());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, approvalDueDateResult);
    assertSame(ofResult6, dueDateResult);
    assertSame(ofResult5, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
    SurveyInstance instance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.surveyEntityExternalId()).thenReturn("42");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult3);
    when(instance.originalInstanceId()).thenReturn(1L);
    when(instance.approvedBy()).thenReturn("Approved By");
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.approvedAt()).thenReturn(ofResult4.atStartOfDay());
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.submittedBy()).thenReturn(null);
    when(instance.surveyEntity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

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
    LocalDateTime approvedAtResult = actualCopyOfResult.approvedAt();
    LocalTime toLocalTimeResult = approvedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = approvedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertNull(actualCopyOfResult.submittedBy());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, approvalDueDateResult);
    assertSame(ofResult6, dueDateResult);
    assertSame(ofResult5, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#approvalDueDate()}
   */
  @Test
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).approvalDueDate());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#approvedAt()}
   */
  @Test
  void testJsonApprovedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).approvedAt());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#approvedBy()}
   */
  @Test
  void testJsonApprovedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).approvedBy());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).dueDate());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#issuedOn()}
   */
  @Test
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).issuedOn());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstance.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstance.Json actualJson = new ImmutableSurveyInstance.Json();

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
   * Method under test: {@link ImmutableSurveyInstance.Json#originalInstanceId()}
   */
  @Test
  void testJsonOriginalInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).originalInstanceId());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#owningRole()}
   */
  @Test
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).owningRole());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#qualifierEntity()}
   */
  @Test
  void testJsonQualifierEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).qualifierEntity());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).status());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#submittedAt()}
   */
  @Test
  void testJsonSubmittedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).submittedAt());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#submittedBy()}
   */
  @Test
  void testJsonSubmittedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).submittedBy());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#surveyEntity()}
   */
  @Test
  void testJsonSurveyEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).surveyEntity());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstance.Json#surveyEntityExternalId()}
   */
  @Test
  void testJsonSurveyEntityExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstance.Json()).surveyEntityExternalId());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstance.Json#surveyRunId()}
   */
  @Test
  void testJsonSurveyRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstance.Json()).surveyRunId());
  }
}
