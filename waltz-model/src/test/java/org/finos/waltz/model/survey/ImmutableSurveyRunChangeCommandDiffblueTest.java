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
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerInvKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerInvKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#addInvolvementKindIds(long)}
   */
  @Test
  void testBuilderAddInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#addInvolvementKindIds(long[])}
   */
  @Test
  void testBuilderAddInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -9L, 1L, -9L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#addOwnerInvKindIds(long)}
   */
  @Test
  void testBuilderAddOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOwnerInvKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#addOwnerInvKindIds(long[])}
   */
  @Test
  void testBuilderAddOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOwnerInvKindIds(1L, -9L, 1L, -9L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#contactEmail(Optional)}
   */
  @Test
  void testBuilderContactEmail() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    Optional<String> contactEmail = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.contactEmail(contactEmail));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSurveyRunChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSurveyRunChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRunChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#from(SurveyRunChangeCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    SurveyRunChangeCommand instance = mock(SurveyRunChangeCommand.class);
    when(instance.ownerInvKindIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).issuanceKind();
    verify(instance).ownerInvKindIds();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#from(SurveyRunChangeCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    SurveyRunChangeCommand instance = mock(SurveyRunChangeCommand.class);
    when(instance.ownerInvKindIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn(null);
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).issuanceKind();
    verify(instance).ownerInvKindIds();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds2() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#issuanceKind(SurveyIssuanceKind)}
   */
  @Test
  void testBuilderIssuanceKind() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.issuanceKind(SurveyIssuanceKind.GROUP));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderOwnerInvKindIds() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ownerInvKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  void testBuilderOwnerInvKindIds2() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ownerInvKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderSelectionOptions() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Builder#surveyTemplateId(Long)}
   */
  @Test
  void testBuilderSurveyTemplateId() {
    // Arrange
    ImmutableSurveyRunChangeCommand.Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand#copyOf(SurveyRunChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyRunChangeCommand instance = mock(SurveyRunChangeCommand.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.approvalDueDate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.contactEmail()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRunChangeCommand actualCopyOfResult = ImmutableSurveyRunChangeCommand.copyOf(instance);

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
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand#copyOf(SurveyRunChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(15L);
    SurveyRunChangeCommand instance = mock(SurveyRunChangeCommand.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.approvalDueDate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.contactEmail()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRunChangeCommand actualCopyOfResult = ImmutableSurveyRunChangeCommand.copyOf(instance);

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
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertTrue(involvementKindIdsResult.contains(15L));
    assertTrue(actualCopyOfResult.ownerInvKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand#copyOf(SurveyRunChangeCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    resultLongSet.add(15L);
    SurveyRunChangeCommand instance = mock(SurveyRunChangeCommand.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.approvalDueDate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.contactEmail()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyRunChangeCommand actualCopyOfResult = ImmutableSurveyRunChangeCommand.copyOf(instance);

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
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertTrue(actualCopyOfResult.ownerInvKindIds().isEmpty());
    assertEquals(resultLongSet, actualCopyOfResult.involvementKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Json#approvalDueDate()}
   */
  @Test
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunChangeCommand.Json()).approvalDueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Json#contactEmail()}
   */
  @Test
  void testJsonContactEmail() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunChangeCommand.Json()).contactEmail());
  }

  /**
   * Method under test: {@link ImmutableSurveyRunChangeCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRunChangeCommand.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSurveyRunChangeCommand.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRunChangeCommand.Json()).dueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Json#involvementKindIds()}
   */
  @Test
  void testJsonInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunChangeCommand.Json()).involvementKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Json#issuanceKind()}
   */
  @Test
  void testJsonIssuanceKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunChangeCommand.Json()).issuanceKind());
  }

  /**
   * Method under test: {@link ImmutableSurveyRunChangeCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRunChangeCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyRunChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyRunChangeCommand.Json actualJson = new ImmutableSurveyRunChangeCommand.Json();

    // Assert
    assertNull(actualJson.surveyTemplateId);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.selectionOptions);
    assertNull(actualJson.issuanceKind);
    assertFalse(actualJson.approvalDueDate.isPresent());
    assertFalse(actualJson.contactEmail.isPresent());
    assertFalse(actualJson.dueDate.isPresent());
    assertTrue(actualJson.involvementKindIds.isEmpty());
    assertTrue(actualJson.ownerInvKindIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Json#ownerInvKindIds()}
   */
  @Test
  void testJsonOwnerInvKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunChangeCommand.Json()).ownerInvKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Json#selectionOptions()}
   */
  @Test
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunChangeCommand.Json()).selectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunChangeCommand.Json#surveyTemplateId()}
   */
  @Test
  void testJsonSurveyTemplateId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunChangeCommand.Json()).surveyTemplateId());
  }
}
