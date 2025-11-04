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
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.Test;

class ImmutableInstancesAndRecipientsCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#builder()}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#owningRole(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableInstancesAndRecipientsCreateCommand.Builder actualBuilderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.owningRole("Owning Role"));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#addAllExcludedRecipients(Iterable)}
   */
  @Test
  void testBuilderAddAllExcludedRecipients() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllExcludedRecipients(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#addExcludedRecipients(SurveyInstanceRecipient)}
   */
  @Test
  void testBuilderAddExcludedRecipients() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addExcludedRecipients(new ImmutableSurveyInstanceRecipient.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#addExcludedRecipients(SurveyInstanceRecipient)}
   */
  @Test
  void testBuilderAddExcludedRecipients2() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    ImmutableSurveyInstanceRecipient.Json element = new ImmutableSurveyInstanceRecipient.Json();
    element.setPerson(mock(Person.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addExcludedRecipients(element));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#addExcludedRecipients(SurveyInstanceRecipient[])}
   */
  @Test
  void testBuilderAddExcludedRecipients3() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addExcludedRecipients(new ImmutableSurveyInstanceRecipient.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#addExcludedRecipients(SurveyInstanceRecipient[])}
   */
  @Test
  void testBuilderAddExcludedRecipients4() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    ImmutableSurveyInstanceRecipient.Json json = new ImmutableSurveyInstanceRecipient.Json();
    json.setPerson(mock(Person.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addExcludedRecipients(json));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#approvalDueDate(LocalDate)}
   */
  @Test
  void testBuilderApprovalDueDate() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#approvalDueDate(LocalDate)}
   */
  @Test
  void testBuilderApprovalDueDate2() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Json element = new ImmutableSurveyInstanceRecipient.Json();
    element.setPerson(mock(Person.class));
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();
    builderResult.addExcludedRecipients(element);

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate2() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Json element = new ImmutableSurveyInstanceRecipient.Json();
    element.setPerson(mock(Person.class));
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();
    builderResult.addExcludedRecipients(element);

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#excludedRecipients(Iterable)}
   */
  @Test
  void testBuilderExcludedRecipients() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.excludedRecipients(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.excludedRecipients()).thenReturn(new HashSet<>());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).excludedRecipients();
    verify(instance).owningRole();
    verify(instance).surveyRunId();
    ImmutableInstancesAndRecipientsCreateCommand buildResult = builderResult.build();
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertSame(ofResult, buildResult.approvalDueDate());
    assertSame(ofResult2, buildResult.dueDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenThrow(new IllegalStateException("instance"));
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).owningRole();
    verify(instance).surveyRunId();
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn(null);
    when(instance.excludedRecipients()).thenReturn(new HashSet<>());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).excludedRecipients();
    verify(instance).owningRole();
    verify(instance).surveyRunId();
    ImmutableInstancesAndRecipientsCreateCommand buildResult = builderResult.build();
    assertNull(buildResult.owningRole());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertSame(ofResult, buildResult.approvalDueDate());
    assertSame(ofResult2, buildResult.dueDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    HashSet<SurveyInstanceRecipient> surveyInstanceRecipientSet = new HashSet<>();
    surveyInstanceRecipientSet.add(new ImmutableSurveyInstanceRecipient.Json());
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.excludedRecipients()).thenReturn(surveyInstanceRecipientSet);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).excludedRecipients();
    verify(instance).owningRole();
    verify(instance).surveyRunId();
    ImmutableInstancesAndRecipientsCreateCommand buildResult = builderResult.build();
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals(1, buildResult.excludedRecipients().size());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertSame(ofResult, buildResult.approvalDueDate());
    assertSame(ofResult2, buildResult.dueDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#surveyRunId(Long)}
   */
  @Test
  void testBuilderSurveyRunId() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRunId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Builder#surveyRunId(Long)}
   */
  @Test
  void testBuilderSurveyRunId2() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Json element = new ImmutableSurveyInstanceRecipient.Json();
    element.setPerson(mock(Person.class));
    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand
        .builder();
    builderResult.addExcludedRecipients(element);

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRunId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand#copyOf(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.excludedRecipients()).thenReturn(new HashSet<>());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualCopyOfResult = ImmutableInstancesAndRecipientsCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).excludedRecipients();
    verify(instance).owningRole();
    verify(instance).surveyRunId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertTrue(actualCopyOfResult.excludedRecipients().isEmpty());
    assertSame(ofResult, approvalDueDateResult);
    assertSame(ofResult2, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand#copyOf(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<SurveyInstanceRecipient> surveyInstanceRecipientSet = new HashSet<>();
    surveyInstanceRecipientSet.add(new ImmutableSurveyInstanceRecipient.Json());
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.excludedRecipients()).thenReturn(surveyInstanceRecipientSet);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualCopyOfResult = ImmutableInstancesAndRecipientsCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).excludedRecipients();
    verify(instance).owningRole();
    verify(instance).surveyRunId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals(1, actualCopyOfResult.excludedRecipients().size());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertSame(ofResult, approvalDueDateResult);
    assertSame(ofResult2, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand#copyOf(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<SurveyInstanceRecipient> surveyInstanceRecipientSet = new HashSet<>();
    surveyInstanceRecipientSet.add(new ImmutableSurveyInstanceRecipient.Json());
    surveyInstanceRecipientSet.add(new ImmutableSurveyInstanceRecipient.Json());
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.excludedRecipients()).thenReturn(surveyInstanceRecipientSet);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualCopyOfResult = ImmutableInstancesAndRecipientsCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).excludedRecipients();
    verify(instance).owningRole();
    verify(instance).surveyRunId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(surveyInstanceRecipientSet, actualCopyOfResult.excludedRecipients());
    assertSame(ofResult, approvalDueDateResult);
    assertSame(ofResult2, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(ImmutableInstancesAndRecipientsCreateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand.Json json = new ImmutableInstancesAndRecipientsCreateCommand.Json();
    json.setSurveyRunId(1L);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    json.setDueDate(dueDate);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    json.setApprovalDueDate(approvalDueDate);
    json.setOwningRole(null);
    json.setExcludedRecipients(null);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualFromJsonResult = ImmutableInstancesAndRecipientsCreateCommand
        .fromJson(json);

    // Assert
    LocalDate approvalDueDateResult = actualFromJsonResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualFromJsonResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertNull(actualFromJsonResult.owningRole());
    assertEquals(1L, actualFromJsonResult.surveyRunId().longValue());
    assertTrue(actualFromJsonResult.excludedRecipients().isEmpty());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(ImmutableInstancesAndRecipientsCreateCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<SurveyInstanceRecipient> excludedRecipients = new LinkedHashSet<>();
    excludedRecipients.add(new ImmutableSurveyInstanceRecipient.Json());

    ImmutableInstancesAndRecipientsCreateCommand.Json json = new ImmutableInstancesAndRecipientsCreateCommand.Json();
    json.setSurveyRunId(1L);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    json.setDueDate(dueDate);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    json.setApprovalDueDate(approvalDueDate);
    json.setOwningRole(null);
    json.setExcludedRecipients(excludedRecipients);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualFromJsonResult = ImmutableInstancesAndRecipientsCreateCommand
        .fromJson(json);

    // Assert
    LocalDate approvalDueDateResult = actualFromJsonResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualFromJsonResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertNull(actualFromJsonResult.owningRole());
    assertEquals(1, actualFromJsonResult.excludedRecipients().size());
    assertEquals(1L, actualFromJsonResult.surveyRunId().longValue());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(ImmutableInstancesAndRecipientsCreateCommand.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<SurveyInstanceRecipient> excludedRecipients = new LinkedHashSet<>();
    excludedRecipients.add(new ImmutableSurveyInstanceRecipient.Json());
    excludedRecipients.add(new ImmutableSurveyInstanceRecipient.Json());

    ImmutableInstancesAndRecipientsCreateCommand.Json json = new ImmutableInstancesAndRecipientsCreateCommand.Json();
    json.setSurveyRunId(1L);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    json.setDueDate(dueDate);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    json.setApprovalDueDate(approvalDueDate);
    json.setOwningRole(null);
    json.setExcludedRecipients(excludedRecipients);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualFromJsonResult = ImmutableInstancesAndRecipientsCreateCommand
        .fromJson(json);

    // Assert
    LocalDate approvalDueDateResult = actualFromJsonResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualFromJsonResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertNull(actualFromJsonResult.owningRole());
    assertEquals(1L, actualFromJsonResult.surveyRunId().longValue());
    assertEquals(excludedRecipients, actualFromJsonResult.excludedRecipients());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Json#approvalDueDate()}
   */
  @Test
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInstancesAndRecipientsCreateCommand.Json()).approvalDueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInstancesAndRecipientsCreateCommand.Json()).dueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Json#excludedRecipients()}
   */
  @Test
  void testJsonExcludedRecipients() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInstancesAndRecipientsCreateCommand.Json()).excludedRecipients());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableInstancesAndRecipientsCreateCommand.Json actualJson = new ImmutableInstancesAndRecipientsCreateCommand.Json();

    // Assert
    assertNull(actualJson.surveyRunId);
    assertNull(actualJson.owningRole);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertTrue(actualJson.excludedRecipients.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Json#owningRole()}
   */
  @Test
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInstancesAndRecipientsCreateCommand.Json()).owningRole());
  }

  /**
   * Method under test:
   * {@link ImmutableInstancesAndRecipientsCreateCommand.Json#surveyRunId()}
   */
  @Test
  void testJsonSurveyRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInstancesAndRecipientsCreateCommand.Json()).surveyRunId());
  }
}
