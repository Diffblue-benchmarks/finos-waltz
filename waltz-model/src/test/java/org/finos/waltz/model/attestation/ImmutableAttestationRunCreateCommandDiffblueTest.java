package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.attestation.ImmutableAttestationRunCreateCommand.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationRunCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunCreateCommandDiffblueTest {
  /**
   * Test {@link ImmutableAttestationRunCreateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationRunCreateCommand#builder()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAttestationRunCreateCommand Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.issuedOn(LocalDate)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualAttestedEntityIdResult = ImmutableAttestationRunCreateCommand.builder().attestedEntityId(1L);
    Optional<Long> attestedEntityId = Optional.<Long>of(1L);
    Builder actualAttestedEntityIdResult2 = actualAttestedEntityIdResult.attestedEntityId(attestedEntityId);

    // Assert
    assertSame(actualAttestedEntityIdResult2,
        actualAttestedEntityIdResult2.description("The characteristics of someone or something"));
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -17L, 1L, -17L));
  }

  /**
   * Test Builder {@link Builder#attestedEntityId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#attestedEntityId(long)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedEntityId(long)"})
  void testBuilderAttestedEntityIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityId(1L));
  }

  /**
   * Test Builder {@link Builder#attestedEntityId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#attestedEntityId(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedEntityId(Optional)"})
  void testBuilderAttestedEntityIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    Optional<Long> attestedEntityId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityId(attestedEntityId));
  }

  /**
   * Test Builder {@link Builder#attestedEntityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedEntityKind(EntityKind)"})
  void testBuilderAttestedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityKind(EntityKind.ALL));
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunCreateCommand)} with {@code AttestationRunCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunCreateCommand) with 'AttestationRunCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunCreateCommand)"})
  void testBuilderFromWithAttestationRunCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult);
    when(instance.description()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).selectionOptions();
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunCreateCommand)} with {@code AttestationRunCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunCreateCommand) with 'AttestationRunCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunCreateCommand)"})
  void testBuilderFromWithAttestationRunCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    when(instance.issuedOn()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunCreateCommand)} with {@code AttestationRunCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunCreateCommand) with 'AttestationRunCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunCreateCommand)"})
  void testBuilderFromWithAttestationRunCreateCommand3() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    when(instance.issuedOn()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
    Set<Long> involvementKindIdsResult = actualFromResult.build().involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    Set<Long> involvementKindIdsResult2 = builderResult.build().involvementKindIds();
    assertEquals(1, involvementKindIdsResult2.size());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertTrue(involvementKindIdsResult2.contains(1L));
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunCreateCommand)} with {@code AttestationRunCreateCommand}.
   * <ul>
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunCreateCommand) with 'AttestationRunCreateCommand'; then builder build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunCreateCommand)"})
  void testBuilderFromWithAttestationRunCreateCommand_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
    ImmutableAttestationRunCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(ofResult2, buildResult.dueDate());
    assertSame(ofResult, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunCreateCommand)} with {@code AttestationRunCreateCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunCreateCommand) with 'AttestationRunCreateCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunCreateCommand)"})
  void testBuilderFromWithAttestationRunCreateCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).selectionOptions();
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
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
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Test Builder {@link Builder#targetEntityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#targetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder targetEntityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetEntityKind(EntityKind)"})
  void testBuilderTargetEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityKind(EntityKind.ALL));
  }

  /**
   * Test Json {@link Json#attestedEntityId()}.
   * <p>
   * Method under test: {@link Json#attestedEntityId()}
   */
  @Test
  @DisplayName("Test Json attestedEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.attestedEntityId()"})
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedEntityId());
  }

  /**
   * Test Json {@link Json#attestedEntityKind()}.
   * <p>
   * Method under test: {@link Json#attestedEntityKind()}
   */
  @Test
  @DisplayName("Test Json attestedEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.attestedEntityKind()"})
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedEntityKind());
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
  @MethodsUnderTest({"Set Json.involvementKindIds()"})
  void testJsonInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).involvementKindIds());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.issuedOn);
    assertNull(actualJson.attestedEntityKind);
    assertNull(actualJson.targetEntityKind);
    assertNull(actualJson.selectionOptions);
    assertFalse(actualJson.attestedEntityId.isPresent());
    assertTrue(actualJson.involvementKindIds.isEmpty());
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
   * Test Json {@link Json#targetEntityKind()}.
   * <p>
   * Method under test: {@link Json#targetEntityKind()}
   */
  @Test
  @DisplayName("Test Json targetEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.targetEntityKind()"})
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetEntityKind());
  }
}
