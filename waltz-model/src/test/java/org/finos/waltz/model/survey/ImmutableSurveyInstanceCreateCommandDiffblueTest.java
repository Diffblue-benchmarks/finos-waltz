package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#builder()}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#name(String)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#owningRole(String)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#status(SurveyInstanceStatus)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyInstanceCreateCommand.Builder actualOwningRoleResult = ImmutableSurveyInstanceCreateCommand.builder()
        .name("Name")
        .owningRole("Owning Role");

    // Assert
    assertSame(actualOwningRoleResult, actualOwningRoleResult.status(SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Builder#approvalDueDate(LocalDate)}
   */
  @Test
  void testBuilderApprovalDueDate() {
    // Arrange
    ImmutableSurveyInstanceCreateCommand.Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate() {
    // Arrange
    ImmutableSurveyInstanceCreateCommand.Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableSurveyInstanceCreateCommand.Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Builder#from(SurveyInstanceCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceCreateCommand.Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();
    SurveyInstanceCreateCommand instance = mock(SurveyInstanceCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.name()).thenReturn("Name");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstanceCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).issuedOn();
    verify(instance).name();
    verify(instance).owningRole();
    verify(instance).status();
    verify(instance).surveyRunId();
    ImmutableSurveyInstanceCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult3, buildResult.dueDate());
    assertSame(ofResult, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Builder#from(SurveyInstanceCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceCreateCommand.Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();
    SurveyInstanceCreateCommand instance = mock(SurveyInstanceCreateCommand.class);
    when(instance.owningRole()).thenThrow(new IllegalStateException("instance"));
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.name()).thenReturn("Name");
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).name();
    verify(instance).owningRole();
    verify(instance).status();
    verify(instance).surveyRunId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Builder#from(SurveyInstanceCreateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceCreateCommand.Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();
    SurveyInstanceCreateCommand instance = mock(SurveyInstanceCreateCommand.class);
    when(instance.owningRole()).thenReturn(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.name()).thenReturn("Name");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstanceCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).issuedOn();
    verify(instance).name();
    verify(instance).owningRole();
    verify(instance).status();
    verify(instance).surveyRunId();
    ImmutableSurveyInstanceCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.owningRole());
    assertEquals(1L, buildResult.surveyRunId().longValue());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.status());
    assertSame(ofResult2, buildResult.approvalDueDate());
    assertSame(ofResult3, buildResult.dueDate());
    assertSame(ofResult, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Builder#surveyRunId(Long)}
   */
  @Test
  void testBuilderSurveyRunId() {
    // Arrange
    ImmutableSurveyInstanceCreateCommand.Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRunId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand#copyOf(SurveyInstanceCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceCreateCommand instance = mock(SurveyInstanceCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.name()).thenReturn("Name");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstanceCreateCommand actualCopyOfResult = ImmutableSurveyInstanceCreateCommand.copyOf(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).issuedOn();
    verify(instance).name();
    verify(instance).owningRole();
    verify(instance).status();
    verify(instance).surveyRunId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult3, dueDateResult);
    assertSame(ofResult, issuedOnResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand#copyOf(SurveyInstanceCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyInstanceCreateCommand instance = mock(SurveyInstanceCreateCommand.class);
    when(instance.owningRole()).thenReturn(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.name()).thenReturn("Name");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSurveyInstanceCreateCommand actualCopyOfResult = ImmutableSurveyInstanceCreateCommand.copyOf(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).issuedOn();
    verify(instance).name();
    verify(instance).owningRole();
    verify(instance).status();
    verify(instance).surveyRunId();
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.owningRole());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(ofResult2, approvalDueDateResult);
    assertSame(ofResult3, dueDateResult);
    assertSame(ofResult, issuedOnResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Json#approvalDueDate()}
   */
  @Test
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceCreateCommand.Json()).approvalDueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceCreateCommand.Json()).dueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceCreateCommand.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyInstanceCreateCommand.Json}
   *   <li>
   * {@link ImmutableSurveyInstanceCreateCommand.Json#setApprovalDueDate(LocalDate)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand.Json#setDueDate(LocalDate)}
   *   <li>
   * {@link ImmutableSurveyInstanceCreateCommand.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand.Json#setIssuedOn(LocalDate)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand.Json#setName(String)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand.Json#setOwningRole(String)}
   *   <li>
   * {@link ImmutableSurveyInstanceCreateCommand.Json#setStatus(SurveyInstanceStatus)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand.Json#setSurveyRunId(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyInstanceCreateCommand.Json actualJson = new ImmutableSurveyInstanceCreateCommand.Json();
    actualJson.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    actualJson.setDueDate(LocalDate.of(1970, 1, 1));
    actualJson.setEntityReference(null);
    actualJson.setIssuedOn(LocalDate.of(1970, 1, 1));
    actualJson.setName("Name");
    actualJson.setOwningRole("Owning Role");
    actualJson.setStatus(SurveyInstanceStatus.NOT_STARTED);
    actualJson.setSurveyRunId(1L);

    // Assert
    assertEquals("1970-01-01", actualJson.approvalDueDate.toString());
    assertEquals("1970-01-01", actualJson.dueDate.toString());
    assertEquals("1970-01-01", actualJson.issuedOn.toString());
    assertEquals(1L, actualJson.surveyRunId.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Json#issuedOn()}
   */
  @Test
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceCreateCommand.Json()).issuedOn());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceCreateCommand.Json()).name());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Json#owningRole()}
   */
  @Test
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceCreateCommand.Json()).owningRole());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceCreateCommand.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceCreateCommand.Json()).status());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceCreateCommand.Json#surveyRunId()}
   */
  @Test
  void testJsonSurveyRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceCreateCommand.Json()).surveyRunId());
  }
}
