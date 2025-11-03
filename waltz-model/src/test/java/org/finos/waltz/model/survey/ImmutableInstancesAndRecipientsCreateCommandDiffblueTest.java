package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.survey.ImmutableInstancesAndRecipientsCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableInstancesAndRecipientsCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInstancesAndRecipientsCreateCommandDiffblueTest {
  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#builder()}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#owningRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableInstancesAndRecipientsCreateCommand Builder.build()",
      "Builder Builder.owningRole(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.owningRole("Owning Role"));
  }

  /**
   * Test Builder {@link Builder#addAllExcludedRecipients(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllExcludedRecipients(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllExcludedRecipients(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllExcludedRecipients(Iterable)"})
  void testBuilderAddAllExcludedRecipients_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllExcludedRecipients(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addExcludedRecipients(SurveyInstanceRecipient)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableSurveyInstanceRecipient.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addExcludedRecipients(SurveyInstanceRecipient)}
   */
  @Test
  @DisplayName("Test Builder addExcludedRecipients(SurveyInstanceRecipient) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addExcludedRecipients(SurveyInstanceRecipient)"})
  void testBuilderAddExcludedRecipientsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addExcludedRecipients(new ImmutableSurveyInstanceRecipient.Json()));
  }

  /**
   * Test Builder {@link Builder#addExcludedRecipients(SurveyInstanceRecipient[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableSurveyInstanceRecipient.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addExcludedRecipients(SurveyInstanceRecipient[])}
   */
  @Test
  @DisplayName("Test Builder addExcludedRecipients(SurveyInstanceRecipient[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addExcludedRecipients(SurveyInstanceRecipient[])"})
  void testBuilderAddExcludedRecipientsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addExcludedRecipients(new ImmutableSurveyInstanceRecipient.Json()));
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
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

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
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#excludedRecipients(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#excludedRecipients(Iterable)}
   */
  @Test
  @DisplayName("Test Builder excludedRecipients(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.excludedRecipients(Iterable)"})
  void testBuilderExcludedRecipients_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.excludedRecipients(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(InstancesAndRecipientsCreateCommand)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableSurveyInstanceRecipient.Json} (default constructor).</li>
   *   <li>Then return build excludedRecipients size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InstancesAndRecipientsCreateCommand); given HashSet() add Json (default constructor); then return build excludedRecipients size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InstancesAndRecipientsCreateCommand)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildExcludedRecipientsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    HashSet<SurveyInstanceRecipient> surveyInstanceRecipientSet = new HashSet<>();
    surveyInstanceRecipientSet.add(new ImmutableSurveyInstanceRecipient.Json());
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.excludedRecipients()).thenReturn(surveyInstanceRecipientSet);
    when(instance.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).approvalDueDate();
    verify(instance).dueDate();
    verify(instance).excludedRecipients();
    verify(instance).owningRole();
    verify(instance).surveyRunId();
    assertEquals(1, actualFromResult.build().excludedRecipients().size());
    assertEquals(1, builderResult.build().excludedRecipients().size());
  }

  /**
   * Test Builder {@link Builder#from(InstancesAndRecipientsCreateCommand)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build owningRole is {@code Owning Role}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InstancesAndRecipientsCreateCommand); given HashSet(); then builder build owningRole is 'Owning Role'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InstancesAndRecipientsCreateCommand)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildOwningRoleIsOwningRole() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.excludedRecipients()).thenReturn(new HashSet<>());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(InstancesAndRecipientsCreateCommand)}.
   * <ul>
   *   <li>Then builder build owningRole is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InstancesAndRecipientsCreateCommand); then builder build owningRole is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InstancesAndRecipientsCreateCommand)"})
  void testBuilderFrom_thenBuilderBuildOwningRoleIsNull() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();
    InstancesAndRecipientsCreateCommand instance = mock(InstancesAndRecipientsCreateCommand.class);
    when(instance.owningRole()).thenReturn(null);
    when(instance.excludedRecipients()).thenReturn(new HashSet<>());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.approvalDueDate()).thenReturn(ofResult);
    when(instance.surveyRunId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(InstancesAndRecipientsCreateCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InstancesAndRecipientsCreateCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InstancesAndRecipientsCreateCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();
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
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

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
   * Test Json {@link Json#excludedRecipients()}.
   * <p>
   * Method under test: {@link Json#excludedRecipients()}
   */
  @Test
  @DisplayName("Test Json excludedRecipients()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.excludedRecipients()"})
  void testJsonExcludedRecipients() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).excludedRecipients());
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
    assertNull(actualJson.surveyRunId);
    assertNull(actualJson.owningRole);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertTrue(actualJson.excludedRecipients.isEmpty());
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
