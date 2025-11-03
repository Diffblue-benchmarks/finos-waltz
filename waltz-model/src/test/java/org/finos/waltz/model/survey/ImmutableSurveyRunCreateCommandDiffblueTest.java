package org.finos.waltz.model.survey;

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
import java.util.LinkedHashSet;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.survey.ImmutableSurveyRunCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunCreateCommandDiffblueTest {
  /**
   * Test {@link ImmutableSurveyRunCreateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyRunCreateCommand#builder()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyRunCreateCommand Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyRunCreateCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#addAllInvolvementKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllInvolvementKindIds(Iterable)"})
  void testBuilderAddAllInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllInvolvementKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllInvolvementKindIds(Iterable)"})
  void testBuilderAddAllInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllOwnerInvKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOwnerInvKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOwnerInvKindIds(Iterable)"})
  void testBuilderAddAllOwnerInvKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerInvKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllOwnerInvKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOwnerInvKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOwnerInvKindIds(Iterable)"})
  void testBuilderAddAllOwnerInvKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerInvKindIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addInvolvementKindIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addInvolvementKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addInvolvementKindIds(long)"})
  void testBuilderAddInvolvementKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Test Builder {@link Builder#addInvolvementKindIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addInvolvementKindIds(long[])"})
  void testBuilderAddInvolvementKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -65L, 1L, -65L));
  }

  /**
   * Test Builder {@link Builder#addOwnerInvKindIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addOwnerInvKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addOwnerInvKindIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOwnerInvKindIds(long)"})
  void testBuilderAddOwnerInvKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOwnerInvKindIds(1L));
  }

  /**
   * Test Builder {@link Builder#addOwnerInvKindIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addOwnerInvKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addOwnerInvKindIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOwnerInvKindIds(long[])"})
  void testBuilderAddOwnerInvKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOwnerInvKindIds(1L, -65L, 1L, -65L));
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.approvalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#contactEmail(String)}.
   * <p>
   * Method under test: {@link Builder#contactEmail(String)}
   */
  @Test
  @DisplayName("Test Builder contactEmail(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.contactEmail(String)"})
  void testBuilderContactEmail() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.contactEmail("jane.doe@example.org"));
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunCreateCommand)} with {@code SurveyRunCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunCreateCommand) with 'SurveyRunCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyRunCreateCommand)"})
  void testBuilderFromWithSurveyRunCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
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
   * Test Builder {@link Builder#from(SurveyRunCreateCommand)} with {@code SurveyRunCreateCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunCreateCommand) with 'SurveyRunCreateCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyRunCreateCommand)"})
  void testBuilderFromWithSurveyRunCreateCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
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
   * Test Builder {@link Builder#involvementKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementKindIds(Iterable)"})
  void testBuilderInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#involvementKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementKindIds(Iterable)"})
  void testBuilderInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#issuanceKind(SurveyIssuanceKind)}.
   * <p>
   * Method under test: {@link Builder#issuanceKind(SurveyIssuanceKind)}
   */
  @Test
  @DisplayName("Test Builder issuanceKind(SurveyIssuanceKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.issuanceKind(SurveyIssuanceKind)"})
  void testBuilderIssuanceKind() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.issuanceKind(SurveyIssuanceKind.GROUP));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#ownerInvKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ownerInvKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ownerInvKindIds(Iterable)"})
  void testBuilderOwnerInvKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ownerInvKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#ownerInvKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ownerInvKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ownerInvKindIds(Iterable)"})
  void testBuilderOwnerInvKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ownerInvKindIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#selectionOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>When {@link IdSelectionOptions}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder selectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.selectionOptions(IdSelectionOptions)"})
  void testBuilderSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Test Builder {@link Builder#surveyTemplateId(Long)}.
   * <p>
   * Method under test: {@link Builder#surveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyTemplateId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyTemplateId(Long)"})
  void testBuilderSurveyTemplateId() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateId(1L));
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
   * Test Json {@link Json#contactEmail()}.
   * <p>
   * Method under test: {@link Json#contactEmail()}
   */
  @Test
  @DisplayName("Test Json contactEmail()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.contactEmail()"})
  void testJsonContactEmail() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).contactEmail());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
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
   * Test Json {@link Json#involvementKindIds()}.
   * <p>
   * Method under test: {@link Json#involvementKindIds()}
   */
  @Test
  @DisplayName("Test Json involvementKindIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.involvementKindIds()"})
  void testJsonInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).involvementKindIds());
  }

  /**
   * Test Json {@link Json#issuanceKind()}.
   * <p>
   * Method under test: {@link Json#issuanceKind()}
   */
  @Test
  @DisplayName("Test Json issuanceKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyIssuanceKind Json.issuanceKind()"})
  void testJsonIssuanceKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).issuanceKind());
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
   * Test Json {@link Json#ownerInvKindIds()}.
   * <p>
   * Method under test: {@link Json#ownerInvKindIds()}
   */
  @Test
  @DisplayName("Test Json ownerInvKindIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.ownerInvKindIds()"})
  void testJsonOwnerInvKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ownerInvKindIds());
  }

  /**
   * Test Json {@link Json#selectionOptions()}.
   * <p>
   * Method under test: {@link Json#selectionOptions()}
   */
  @Test
  @DisplayName("Test Json selectionOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions Json.selectionOptions()"})
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).selectionOptions());
  }

  /**
   * Test Json {@link Json#surveyTemplateId()}.
   * <p>
   * Method under test: {@link Json#surveyTemplateId()}
   */
  @Test
  @DisplayName("Test Json surveyTemplateId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.surveyTemplateId()"})
  void testJsonSurveyTemplateId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyTemplateId());
  }
}
