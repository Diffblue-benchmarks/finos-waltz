package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyRun#builder()}
   *   <li>{@link ImmutableSurveyRun#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyRun.Builder actualIdResult = ImmutableSurveyRun.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerInvKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerInvKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#addInvolvementKindIds(long)}
   */
  @Test
  void testBuilderAddInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#addInvolvementKindIds(long[])}
   */
  @Test
  void testBuilderAddInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -257L, 1L, -257L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#addOwnerInvKindIds(long)}
   */
  @Test
  void testBuilderAddOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOwnerInvKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#addOwnerInvKindIds(long[])}
   */
  @Test
  void testBuilderAddOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOwnerInvKindIds(1L, -257L, 1L, -257L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#approvalDueDate(LocalDate)}
   */
  @Test
  void testBuilderApprovalDueDate() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#contactEmail(String)}
   */
  @Test
  void testBuilderContactEmail() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.contactEmail("jane.doe@example.org"));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSurveyRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSurveyRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#from(SurveyRun)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#from(SurveyRun)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.description()).thenReturn(null);
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(elements));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#isDefault(boolean)}
   */
  @Test
  void testBuilderIsDefault() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isDefault(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#issuanceKind(SurveyIssuanceKind)}
   */
  @Test
  void testBuilderIssuanceKind() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.issuanceKind(SurveyIssuanceKind.GROUP));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#ownerId(Long)}
   */
  @Test
  void testBuilderOwnerId() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ownerId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ownerInvKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ownerInvKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRun.Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderSelectionOptions() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#status(SurveyRunStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(SurveyRunStatus.DRAFT));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Builder#surveyTemplateId(Long)}
   */
  @Test
  void testBuilderSurveyTemplateId() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateId(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyRun#copyOf(SurveyRun)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyRunStatus.DRAFT);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.isDefault()).thenReturn(true);
    when(instance.ownerId()).thenReturn(1L);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRun actualCopyOfResult = ImmutableSurveyRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).isDefault();
    verify(instance).issuanceKind();
    verify(instance).issuedOn();
    verify(instance).ownerId();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.status());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertTrue(actualCopyOfResult.isDefault());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult4, dueDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun#copyOf(SurveyRun)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(SurveyRunStatus.DRAFT);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.isDefault()).thenReturn(true);
    when(instance.ownerId()).thenReturn(1L);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.issuedOn()).thenReturn(ofResult2);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRun actualCopyOfResult = ImmutableSurveyRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).isDefault();
    verify(instance).issuanceKind();
    verify(instance).issuedOn();
    verify(instance).ownerId();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.status());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertTrue(actualCopyOfResult.isDefault());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
    assertSame(ofResult, approvalDueDateResult);
    assertSame(ofResult3, dueDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun#copyOf(SurveyRun)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(511L);
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyRunStatus.DRAFT);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.ownerInvKindIds()).thenReturn(resultLongSet);
    when(instance.isDefault()).thenReturn(true);
    when(instance.ownerId()).thenReturn(1L);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRun actualCopyOfResult = ImmutableSurveyRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).isDefault();
    verify(instance).issuanceKind();
    verify(instance).issuedOn();
    verify(instance).ownerId();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    Set<Long> ownerInvKindIdsResult = actualCopyOfResult.ownerInvKindIds();
    assertEquals(1, ownerInvKindIdsResult.size());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(ownerInvKindIdsResult.contains(511L));
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertTrue(actualCopyOfResult.isDefault());
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult4, dueDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun#copyOf(SurveyRun)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    resultLongSet.add(511L);
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyRunStatus.DRAFT);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.ownerInvKindIds()).thenReturn(resultLongSet);
    when(instance.isDefault()).thenReturn(true);
    when(instance.ownerId()).thenReturn(1L);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRun actualCopyOfResult = ImmutableSurveyRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).isDefault();
    verify(instance).issuanceKind();
    verify(instance).issuedOn();
    verify(instance).ownerId();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertTrue(actualCopyOfResult.isDefault());
    assertEquals(resultLongSet, actualCopyOfResult.ownerInvKindIds());
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult4, dueDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun#copyOf(SurveyRun)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyRunStatus.DRAFT);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.isDefault()).thenReturn(false);
    when(instance.ownerId()).thenReturn(1L);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRun actualCopyOfResult = ImmutableSurveyRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).isDefault();
    verify(instance).issuanceKind();
    verify(instance).issuedOn();
    verify(instance).ownerId();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.status());
    assertFalse(actualCopyOfResult.isDefault());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult4, dueDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun#copyOf(SurveyRun)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyRunStatus.DRAFT);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.isDefault()).thenReturn(true);
    when(instance.ownerId()).thenReturn(1L);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.issuedOn()).thenReturn(emptyResult);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRun actualCopyOfResult = ImmutableSurveyRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).isDefault();
    verify(instance).issuanceKind();
    verify(instance).issuedOn();
    verify(instance).ownerId();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.status());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertTrue(actualCopyOfResult.isDefault());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult3, dueDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun#copyOf(SurveyRun)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(511L);
    SurveyRun instance = mock(SurveyRun.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyRunStatus.DRAFT);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.isDefault()).thenReturn(true);
    when(instance.ownerId()).thenReturn(1L);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRun actualCopyOfResult = ImmutableSurveyRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).isDefault();
    verify(instance).issuanceKind();
    verify(instance).issuedOn();
    verify(instance).ownerId();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(involvementKindIdsResult.contains(511L));
    assertTrue(actualCopyOfResult.ownerInvKindIds().isEmpty());
    assertTrue(actualCopyOfResult.isDefault());
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult4, dueDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#approvalDueDate()}
   */
  @Test
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).approvalDueDate());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#contactEmail()}
   */
  @Test
  void testJsonContactEmail() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).contactEmail());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).dueDate());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#involvementKindIds()}
   */
  @Test
  void testJsonInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).involvementKindIds());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#isDefault()}
   */
  @Test
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).isDefault());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#issuanceKind()}
   */
  @Test
  void testJsonIssuanceKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).issuanceKind());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#issuedOn()}
   */
  @Test
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).issuedOn());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyRun.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyRun.Json actualJson = new ImmutableSurveyRun.Json();

    // Assert
    assertNull(actualJson.ownerId);
    assertNull(actualJson.surveyTemplateId);
    assertNull(actualJson.contactEmail);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.selectionOptions);
    assertNull(actualJson.issuanceKind);
    assertNull(actualJson.status);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.issuedOn.isPresent());
    assertFalse(actualJson.isDefault);
    assertFalse(actualJson.isDefaultIsSet);
    assertTrue(actualJson.involvementKindIds.isEmpty());
    assertTrue(actualJson.ownerInvKindIds.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#ownerId()}
   */
  @Test
  void testJsonOwnerId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).ownerId());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#ownerInvKindIds()}
   */
  @Test
  void testJsonOwnerInvKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).ownerInvKindIds());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#selectionOptions()}
   */
  @Test
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).selectionOptions());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#setIsDefault(boolean)}
   */
  @Test
  void testJsonSetIsDefault() {
    // Arrange
    ImmutableSurveyRun.Json json = new ImmutableSurveyRun.Json();

    // Act
    json.setIsDefault(true);

    // Assert
    assertTrue(json.isDefault);
    assertTrue(json.isDefaultIsSet);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#setIsDefault(boolean)}
   */
  @Test
  void testJsonSetIsDefault2() {
    // Arrange
    ImmutableSurveyRun.Json json = new ImmutableSurveyRun.Json();
    json.setSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    json.setIsDefault(true);

    // Assert
    assertTrue(json.isDefault);
    assertTrue(json.isDefaultIsSet);
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).status());
  }

  /**
   * Method under test: {@link ImmutableSurveyRun.Json#surveyTemplateId()}
   */
  @Test
  void testJsonSurveyTemplateId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRun.Json()).surveyTemplateId());
  }
}
