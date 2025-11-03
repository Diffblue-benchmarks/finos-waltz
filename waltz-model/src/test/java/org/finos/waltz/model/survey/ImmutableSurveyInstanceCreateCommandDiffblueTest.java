package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceCreateCommandDiffblueTest {
  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#builder()}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#name(String)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#owningRole(String)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#status(SurveyInstanceStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceCreateCommand Builder.build()", "Builder Builder.issuedOn(LocalDate)",
      "Builder Builder.name(String)", "Builder Builder.owningRole(String)",
      "Builder Builder.status(SurveyInstanceStatus)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualOwningRoleResult = ImmutableSurveyInstanceCreateCommand.builder()
        .name("Name")
        .owningRole("Owning Role");

    // Assert
    assertSame(actualOwningRoleResult, actualOwningRoleResult.status(SurveyInstanceStatus.NOT_STARTED));
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
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceCreateCommand)}.
   * <ul>
   *   <li>Given {@code Owning Role}.</li>
   *   <li>Then builder build owningRole is {@code Owning Role}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceCreateCommand); given 'Owning Role'; then builder build owningRole is 'Owning Role'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceCreateCommand)"})
  void testBuilderFrom_givenOwningRole_thenBuilderBuildOwningRoleIsOwningRole() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyInstanceCreateCommand)}.
   * <ul>
   *   <li>Then builder build owningRole is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceCreateCommand); then builder build owningRole is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceCreateCommand)"})
  void testBuilderFrom_thenBuilderBuildOwningRoleIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyInstanceCreateCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceCreateCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceCreateCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();
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
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

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
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setApprovalDueDate(LocalDate)}
   *   <li>{@link Json#setDueDate(LocalDate)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setIssuedOn(LocalDate)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setOwningRole(String)}
   *   <li>{@link Json#setStatus(SurveyInstanceStatus)}
   *   <li>{@link Json#setSurveyRunId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setApprovalDueDate(LocalDate)", "void Json.setDueDate(LocalDate)",
      "void Json.setEntityReference(EntityReference)", "void Json.setIssuedOn(LocalDate)", "void Json.setName(String)",
      "void Json.setOwningRole(String)", "void Json.setStatus(SurveyInstanceStatus)", "void Json.setSurveyRunId(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
