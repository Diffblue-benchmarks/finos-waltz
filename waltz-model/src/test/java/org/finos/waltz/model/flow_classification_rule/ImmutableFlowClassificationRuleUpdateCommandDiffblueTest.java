package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleUpdateCommand.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleUpdateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleUpdateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#message(String)}
   *   <li>{@link Builder#severity(MessageSeverity)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.message(String)",
    "Builder Builder.severity(MessageSeverity)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableFlowClassificationRuleUpdateCommand
        actualImmutableFlowClassificationRuleUpdateCommand =
            actualIdResult
                .id(id)
                .message("Not all who wander are lost")
                .severity(MessageSeverity.NONE)
                .build();

    // Assert
    assertEquals(
        "Not all who wander are lost",
        actualImmutableFlowClassificationRuleUpdateCommand.message());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableFlowClassificationRuleUpdateCommand.description());
    assertEquals(1L, actualImmutableFlowClassificationRuleUpdateCommand.classificationId());
    assertEquals(
        MessageSeverity.NONE, actualImmutableFlowClassificationRuleUpdateCommand.severity());
  }

  /**
   * Test Builder {@link Builder#classificationId(long)}.
   *
   * <p>Method under test: {@link Builder#classificationId(long)}
   */
  @Test
  @DisplayName("Test Builder classificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.classificationId(long)"})
  void testBuilderClassificationId() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

    // Act
    Builder actualClassificationIdResult = builderResult.classificationId(1L);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        builderResult.build();
    assertNull(immutableFlowClassificationRuleUpdateCommand.description());
    assertNull(immutableFlowClassificationRuleUpdateCommand.message());
    assertNull(immutableFlowClassificationRuleUpdateCommand.severity());
    assertEquals(1L, immutableFlowClassificationRuleUpdateCommand.classificationId());
    assertSame(builderResult, actualClassificationIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    ImmutableFlowClassificationRuleUpdateCommand instance =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand
        actualImmutableFlowClassificationRuleUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

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
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code
   * FlowClassificationRuleUpdateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    ImmutableFlowClassificationRuleUpdateCommand instance =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand
        actualImmutableFlowClassificationRuleUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code
   * FlowClassificationRuleUpdateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    ImmutableFlowClassificationRuleUpdateCommand instance =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description(null)
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand
        actualImmutableFlowClassificationRuleUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code
   * FlowClassificationRuleUpdateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    ImmutableFlowClassificationRuleUpdateCommand instance =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message(null)
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand
        actualImmutableFlowClassificationRuleUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code
   * FlowClassificationRuleUpdateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand4() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    ImmutableFlowClassificationRuleUpdateCommand instance =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand
        actualImmutableFlowClassificationRuleUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    ImmutableFlowClassificationRuleUpdateCommand instance =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand
        actualImmutableFlowClassificationRuleUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test {@link
   * ImmutableFlowClassificationRuleUpdateCommand#copyOf(FlowClassificationRuleUpdateCommand)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleUpdateCommand#copyOf(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowClassificationRuleUpdateCommand); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.copyOf(FlowClassificationRuleUpdateCommand)"
  })
  void testCopyOf_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand instance =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualCopyOfResult =
        ImmutableFlowClassificationRuleUpdateCommand.copyOf(instance);

    // Assert
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.severity());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}, and {@link
   * ImmutableFlowClassificationRuleUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleUpdateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand2 =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act and Assert
    assertEquals(
        immutableFlowClassificationRuleUpdateCommand,
        immutableFlowClassificationRuleUpdateCommand2);
    assertEquals(
        immutableFlowClassificationRuleUpdateCommand.hashCode(),
        immutableFlowClassificationRuleUpdateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}, and {@link
   * ImmutableFlowClassificationRuleUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleUpdateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act and Assert
    assertEquals(
        immutableFlowClassificationRuleUpdateCommand, immutableFlowClassificationRuleUpdateCommand);
    int expectedHashCodeResult = immutableFlowClassificationRuleUpdateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowClassificationRuleUpdateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleUpdateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(2L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleUpdateCommand,
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleUpdateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(2L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleUpdateCommand,
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleUpdateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Message")
            .severity(MessageSeverity.NONE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleUpdateCommand,
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleUpdateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.INFORMATION)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleUpdateCommand,
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleUpdateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleUpdateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build(),
        "Different type to ImmutableFlowClassificationRuleUpdateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#classificationId()}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#description()}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#message()}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#severity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableFlowClassificationRuleUpdateCommand.classificationId()",
    "String ImmutableFlowClassificationRuleUpdateCommand.description()",
    "String ImmutableFlowClassificationRuleUpdateCommand.message()",
    "MessageSeverity ImmutableFlowClassificationRuleUpdateCommand.severity()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    long actualClassificationIdResult =
        immutableFlowClassificationRuleUpdateCommand.classificationId();
    String actualDescriptionResult = immutableFlowClassificationRuleUpdateCommand.description();
    String actualMessageResult = immutableFlowClassificationRuleUpdateCommand.message();

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualClassificationIdResult);
    assertEquals(MessageSeverity.NONE, immutableFlowClassificationRuleUpdateCommand.severity());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#id()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowClassificationRuleUpdateCommand.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#classificationId()}.
   *
   * <p>Method under test: {@link Json#classificationId()}
   */
  @Test
  @DisplayName("Test Json classificationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.classificationId()"})
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().classificationId());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#message()}.
   *
   * <p>Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().message());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.message);
    assertNull(actualJson.severity);
    assertEquals(0L, actualJson.classificationId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.classificationIdIsSet);
  }

  /**
   * Test Json {@link Json#setClassificationId(long)}.
   *
   * <p>Method under test: {@link Json#setClassificationId(long)}
   */
  @Test
  @DisplayName("Test Json setClassificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setClassificationId(long)"})
  void testJsonSetClassificationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setClassificationId(1L);

    // Assert
    assertEquals(1L, json.classificationId);
    assertTrue(json.classificationIdIsSet);
  }

  /**
   * Test Json {@link Json#severity()}.
   *
   * <p>Method under test: {@link Json#severity()}
   */
  @Test
  @DisplayName("Test Json severity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity Json.severity()"})
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().severity());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowClassificationRuleUpdateCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "FlowClassificationRuleUpdateCommand{id=1, classificationId=1, severity=NONE}",
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message(null)
            .severity(MessageSeverity.NONE)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowClassificationRuleUpdateCommand.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "FlowClassificationRuleUpdateCommand{id=1, classificationId=1, message=Not all who wander are lost}",
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(null)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowClassificationRuleUpdateCommand.toString()"})
  void testToString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "FlowClassificationRuleUpdateCommand{id=1, classificationId=1, severity=NONE, message=Not all who wander"
            + " are lost}",
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withClassificationId(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleUpdateCommand#withClassificationId(long)}
   */
  @Test
  @DisplayName("Test withClassificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withClassificationId(long)"
  })
  void testWithClassificationId() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(42L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithClassificationIdResult =
        immutableFlowClassificationRuleUpdateCommand.withClassificationId(42L);

    // Assert
    assertSame(immutableFlowClassificationRuleUpdateCommand, actualWithClassificationIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withClassificationId(long)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleUpdateCommand#withClassificationId(long)}
   */
  @Test
  @DisplayName(
      "Test withClassificationId(long); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withClassificationId(long)"
  })
  void testWithClassificationId_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithClassificationIdResult =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build()
            .withClassificationId(42L);

    // Assert
    assertEquals("Not all who wander are lost", actualWithClassificationIdResult.message());
    assertEquals(
        "The characteristics of someone or something",
        actualWithClassificationIdResult.description());
    assertEquals(42L, actualWithClassificationIdResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualWithClassificationIdResult.severity());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleUpdateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithDescriptionResult =
        immutableFlowClassificationRuleUpdateCommand.withDescription("42");

    // Assert
    assertEquals(immutableFlowClassificationRuleUpdateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleUpdateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("42")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithDescriptionResult =
        immutableFlowClassificationRuleUpdateCommand.withDescription("42");

    // Assert
    assertSame(immutableFlowClassificationRuleUpdateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithIdResult =
        immutableFlowClassificationRuleUpdateCommand.withId(optional);

    // Assert
    assertSame(immutableFlowClassificationRuleUpdateCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(2L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithIdResult =
        immutableFlowClassificationRuleUpdateCommand.withId(optional);

    // Assert
    assertEquals("Not all who wander are lost", actualWithIdResult.message());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualWithIdResult.severity());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithIdResult =
        immutableFlowClassificationRuleUpdateCommand.withId(1L);

    // Assert
    assertSame(immutableFlowClassificationRuleUpdateCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithIdResult =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Not all who wander are lost", actualWithIdResult.message());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualWithIdResult.severity());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withMessage(String)"
  })
  void testWithMessage() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("42")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithMessageResult =
        immutableFlowClassificationRuleUpdateCommand.withMessage("42");

    // Assert
    assertSame(immutableFlowClassificationRuleUpdateCommand, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return message is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleUpdateCommand#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then return message is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withMessage(String)"
  })
  void testWithMessage_thenReturnMessageIs42() {
    // Arrange and Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithMessageResult =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build()
            .withMessage("42");

    // Assert
    assertEquals("42", actualWithMessageResult.message());
    assertEquals(
        "The characteristics of someone or something", actualWithMessageResult.description());
    assertEquals(1L, actualWithMessageResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualWithMessageResult.severity());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withSeverity(MessageSeverity)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleUpdateCommand#withSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName("Test withSeverity(MessageSeverity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withSeverity(MessageSeverity)"
  })
  void testWithSeverity() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand immutableFlowClassificationRuleUpdateCommand =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.NONE)
            .build();

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithSeverityResult =
        immutableFlowClassificationRuleUpdateCommand.withSeverity(MessageSeverity.NONE);

    // Assert
    assertSame(immutableFlowClassificationRuleUpdateCommand, actualWithSeverityResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#withSeverity(MessageSeverity)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleUpdateCommand#withSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName(
      "Test withSeverity(MessageSeverity); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleUpdateCommand ImmutableFlowClassificationRuleUpdateCommand.withSeverity(MessageSeverity)"
  })
  void testWithSeverity_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    ImmutableFlowClassificationRuleUpdateCommand actualWithSeverityResult =
        ImmutableFlowClassificationRuleUpdateCommand.builder()
            .classificationId(1L)
            .description("The characteristics of someone or something")
            .id(1L)
            .message("Not all who wander are lost")
            .severity(MessageSeverity.INFORMATION)
            .build()
            .withSeverity(MessageSeverity.NONE);

    // Assert
    assertEquals("Not all who wander are lost", actualWithSeverityResult.message());
    assertEquals(
        "The characteristics of someone or something", actualWithSeverityResult.description());
    assertEquals(1L, actualWithSeverityResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualWithSeverityResult.severity());
  }
}
