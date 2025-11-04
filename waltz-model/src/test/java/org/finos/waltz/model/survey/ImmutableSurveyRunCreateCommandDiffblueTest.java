package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyRunCreateCommand#builder()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyRunCreateCommand.Builder actualBuilderResult = ImmutableSurveyRunCreateCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerInvKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerInvKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#addInvolvementKindIds(long)}
   */
  @Test
  void testBuilderAddInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#addInvolvementKindIds(long[])}
   */
  @Test
  void testBuilderAddInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -65L, 1L, -65L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#addOwnerInvKindIds(long)}
   */
  @Test
  void testBuilderAddOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOwnerInvKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#addOwnerInvKindIds(long[])}
   */
  @Test
  void testBuilderAddOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOwnerInvKindIds(1L, -65L, 1L, -65L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#approvalDueDate(LocalDate)}
   */
  @Test
  void testBuilderApprovalDueDate() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#contactEmail(String)}
   */
  @Test
  void testBuilderContactEmail() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.contactEmail("jane.doe@example.org"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSurveyRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSurveyRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#from(SurveyRunCreateCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    SurveyRunCreateCommand instance = mock(SurveyRunCreateCommand.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).issuanceKind();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#from(SurveyRunCreateCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    SurveyRunCreateCommand instance = mock(SurveyRunCreateCommand.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.description()).thenReturn(null);
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).issuanceKind();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#issuanceKind(SurveyIssuanceKind)}
   */
  @Test
  void testBuilderIssuanceKind() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.issuanceKind(SurveyIssuanceKind.GROUP));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ownerInvKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ownerInvKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderSelectionOptions() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Builder#surveyTemplateId(Long)}
   */
  @Test
  void testBuilderSurveyTemplateId() {
    // Arrange
    ImmutableSurveyRunCreateCommand.Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand#copyOf(SurveyRunCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyRunCreateCommand instance = mock(SurveyRunCreateCommand.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRunCreateCommand actualCopyOfResult = ImmutableSurveyRunCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuanceKind();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
    assertSame(ofResult, approvalDueDateResult);
    assertSame(ofResult2, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand#copyOf(SurveyRunCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(127L);
    SurveyRunCreateCommand instance = mock(SurveyRunCreateCommand.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRunCreateCommand actualCopyOfResult = ImmutableSurveyRunCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuanceKind();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
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
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertTrue(involvementKindIdsResult.contains(127L));
    assertTrue(actualCopyOfResult.ownerInvKindIds().isEmpty());
    assertSame(ofResult, approvalDueDateResult);
    assertSame(ofResult2, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand#copyOf(SurveyRunCreateCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    resultLongSet.add(127L);
    SurveyRunCreateCommand instance = mock(SurveyRunCreateCommand.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    when(instance.contactEmail()).thenReturn("jane.doe@example.org");
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRunCreateCommand actualCopyOfResult = ImmutableSurveyRunCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).approvalDueDate();
    verify(instance).contactEmail();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuanceKind();
    verify(instance).ownerInvKindIds();
    verify(instance).selectionOptions();
    verify(instance).surveyTemplateId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertTrue(actualCopyOfResult.ownerInvKindIds().isEmpty());
    assertEquals(resultLongSet, actualCopyOfResult.involvementKindIds());
    assertSame(ofResult, approvalDueDateResult);
    assertSame(ofResult2, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Json#approvalDueDate()}
   */
  @Test
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCreateCommand.Json()).approvalDueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Json#contactEmail()}
   */
  @Test
  void testJsonContactEmail() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCreateCommand.Json()).contactEmail());
  }

  /**
   * Method under test: {@link ImmutableSurveyRunCreateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRunCreateCommand.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSurveyRunCreateCommand.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRunCreateCommand.Json()).dueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Json#involvementKindIds()}
   */
  @Test
  void testJsonInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCreateCommand.Json()).involvementKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Json#issuanceKind()}
   */
  @Test
  void testJsonIssuanceKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCreateCommand.Json()).issuanceKind());
  }

  /**
   * Method under test: {@link ImmutableSurveyRunCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRunCreateCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyRunCreateCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyRunCreateCommand.Json actualJson = new ImmutableSurveyRunCreateCommand.Json();

    // Assert
    assertNull(actualJson.surveyTemplateId);
    assertNull(actualJson.contactEmail);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.selectionOptions);
    assertNull(actualJson.issuanceKind);
    assertTrue(actualJson.involvementKindIds.isEmpty());
    assertTrue(actualJson.ownerInvKindIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Json#ownerInvKindIds()}
   */
  @Test
  void testJsonOwnerInvKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCreateCommand.Json()).ownerInvKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Json#selectionOptions()}
   */
  @Test
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCreateCommand.Json()).selectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCreateCommand.Json#surveyTemplateId()}
   */
  @Test
  void testJsonSurveyTemplateId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCreateCommand.Json()).surveyTemplateId());
  }
}
