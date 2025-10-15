package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristics.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristics.Json;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorRatingCharacteristicsDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#inboundMessage(String)}
   *   <li>{@link Builder#inboundMessageSeverity(MessageSeverity)}
   *   <li>{@link Builder#outboundMessage(String)}
   *   <li>{@link Builder#outboundMessageSeverity(MessageSeverity)}
   *   <li>{@link Builder#sourceOutboundRating(AuthoritativenessRatingValue)}
   *   <li>{@link Builder#targetInboundRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics Builder.build()",
    "Builder Builder.inboundMessage(String)",
    "Builder Builder.inboundMessageSeverity(MessageSeverity)",
    "Builder Builder.outboundMessage(String)",
    "Builder Builder.outboundMessageSeverity(MessageSeverity)",
    "Builder Builder.sourceOutboundRating(AuthoritativenessRatingValue)",
    "Builder Builder.targetInboundRating(AuthoritativenessRatingValue)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualOutboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);
    ImmutableEntityReference source =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSourceResult = actualOutboundMessageSeverityResult.source(source);
    AuthoritativenessRatingValue sourceOutboundRating = AuthoritativenessRatingValue.of("42");
    Builder actualSourceOutboundRatingResult =
        actualSourceResult.sourceOutboundRating(sourceOutboundRating);
    ImmutableEntityReference target =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualTargetResult = actualSourceOutboundRatingResult.target(target);
    AuthoritativenessRatingValue targetInboundRating = AuthoritativenessRatingValue.of("42");
    ImmutableDataTypeDecoratorRatingCharacteristics
        actualImmutableDataTypeDecoratorRatingCharacteristics =
            actualTargetResult.targetInboundRating(targetInboundRating).build();

    // Assert
    AuthoritativenessRatingValue sourceOutboundRatingResult =
        actualImmutableDataTypeDecoratorRatingCharacteristics.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult.value());
    AuthoritativenessRatingValue targetInboundRatingResult =
        actualImmutableDataTypeDecoratorRatingCharacteristics.targetInboundRating();
    assertEquals("42", targetInboundRatingResult.value());
    assertEquals(
        "Inbound Message", actualImmutableDataTypeDecoratorRatingCharacteristics.inboundMessage());
    assertEquals(
        "Outbound Message",
        actualImmutableDataTypeDecoratorRatingCharacteristics.outboundMessage());
    assertEquals(1L, actualImmutableDataTypeDecoratorRatingCharacteristics.dataTypeId());
    assertEquals(
        MessageSeverity.NONE,
        actualImmutableDataTypeDecoratorRatingCharacteristics.inboundMessageSeverity());
    assertEquals(
        MessageSeverity.NONE,
        actualImmutableDataTypeDecoratorRatingCharacteristics.outboundMessageSeverity());
    assertSame(source, actualImmutableDataTypeDecoratorRatingCharacteristics.source());
    assertSame(target, actualImmutableDataTypeDecoratorRatingCharacteristics.target());
    assertSame(sourceOutboundRating, sourceOutboundRatingResult);
    assertSame(targetInboundRating, targetInboundRatingResult);
  }

  /**
   * Test Builder {@link Builder#dataTypeId(long)}.
   *
   * <p>Method under test: {@link Builder#dataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeId(long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    // Act
    Builder actualDataTypeIdResult = builderResult.dataTypeId(1L);

    // Assert
    assertSame(builderResult, actualDataTypeIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristics)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics instance =
        targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act and Assert
    ImmutableDataTypeDecoratorRatingCharacteristics
        actualImmutableDataTypeDecoratorRatingCharacteristics =
            builderResult.from(instance).build();
    assertEquals(instance, actualImmutableDataTypeDecoratorRatingCharacteristics);
    ImmutableDataTypeDecoratorRatingCharacteristics
        actualImmutableDataTypeDecoratorRatingCharacteristics2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecoratorRatingCharacteristics2);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristics)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage(null)
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics instance =
        targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act and Assert
    ImmutableDataTypeDecoratorRatingCharacteristics
        actualImmutableDataTypeDecoratorRatingCharacteristics =
            builderResult.from(instance).build();
    assertEquals(instance, actualImmutableDataTypeDecoratorRatingCharacteristics);
    ImmutableDataTypeDecoratorRatingCharacteristics
        actualImmutableDataTypeDecoratorRatingCharacteristics2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecoratorRatingCharacteristics2);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristics)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage(null)
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics instance =
        targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act and Assert
    ImmutableDataTypeDecoratorRatingCharacteristics
        actualImmutableDataTypeDecoratorRatingCharacteristics =
            builderResult.from(instance).build();
    assertEquals(instance, actualImmutableDataTypeDecoratorRatingCharacteristics);
    ImmutableDataTypeDecoratorRatingCharacteristics
        actualImmutableDataTypeDecoratorRatingCharacteristics2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecoratorRatingCharacteristics2);
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    // Act
    Builder actualSourceResult = builderResult.source(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualSourceResult);
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    // Act
    Builder actualTargetResult = builderResult.target(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualTargetResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#copyOf(DataTypeDecoratorRatingCharacteristics)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#copyOf(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DataTypeDecoratorRatingCharacteristics); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.copyOf(DataTypeDecoratorRatingCharacteristics)"
  })
  void testCopyOf_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AuthoritativenessRatingValue sourceOutboundRating = AuthoritativenessRatingValue.of("42");

    Builder sourceOutboundRatingResult = sourceResult.sourceOutboundRating(sourceOutboundRating);

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AuthoritativenessRatingValue targetInboundRating = AuthoritativenessRatingValue.of("42");
    ImmutableDataTypeDecoratorRatingCharacteristics instance =
        targetResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualCopyOfResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.copyOf(instance);

    // Assert
    EntityReference sourceResult2 = actualCopyOfResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualCopyOfResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    AuthoritativenessRatingValue sourceOutboundRatingResult2 =
        actualCopyOfResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult2.value());
    assertEquals("Inbound Message", actualCopyOfResult.inboundMessage());
    assertEquals("Outbound Message", actualCopyOfResult.outboundMessage());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.inboundMessageSeverity());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.outboundMessageSeverity());
    assertEquals(sourceResult2, targetResult2);
    assertSame(sourceOutboundRating, sourceOutboundRatingResult2);
    assertSame(targetInboundRating, actualCopyOfResult.targetInboundRating());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}, and {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics2 =
            targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act and Assert
    assertEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        immutableDataTypeDecoratorRatingCharacteristics2);
    assertEquals(
        immutableDataTypeDecoratorRatingCharacteristics.hashCode(),
        immutableDataTypeDecoratorRatingCharacteristics2.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}, and {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act and Assert
    assertEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        immutableDataTypeDecoratorRatingCharacteristics);
    int expectedHashCodeResult = immutableDataTypeDecoratorRatingCharacteristics.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableDataTypeDecoratorRatingCharacteristics.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(2L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("42")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.INFORMATION)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("42")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.INFORMATION);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("Value"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("Value")).build();

    Builder outboundMessageSeverityResult2 =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult2 =
        outboundMessageSeverityResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult2 =
        sourceResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristics,
        targetResult2.targetInboundRating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build(), null);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorRatingCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristics.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build(),
        "Different type to ImmutableDataTypeDecoratorRatingCharacteristics");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#toString()}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#dataTypeId()}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#inboundMessage()}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#outboundMessage()}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#source()}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#target()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableDataTypeDecoratorRatingCharacteristics.dataTypeId()",
    "String ImmutableDataTypeDecoratorRatingCharacteristics.inboundMessage()",
    "String ImmutableDataTypeDecoratorRatingCharacteristics.outboundMessage()",
    "EntityReference ImmutableDataTypeDecoratorRatingCharacteristics.source()",
    "EntityReference ImmutableDataTypeDecoratorRatingCharacteristics.target()",
    "String ImmutableDataTypeDecoratorRatingCharacteristics.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    String actualToStringResult = immutableDataTypeDecoratorRatingCharacteristics.toString();
    long actualDataTypeIdResult = immutableDataTypeDecoratorRatingCharacteristics.dataTypeId();
    String actualInboundMessageResult =
        immutableDataTypeDecoratorRatingCharacteristics.inboundMessage();
    String actualOutboundMessageResult =
        immutableDataTypeDecoratorRatingCharacteristics.outboundMessage();
    EntityReference actualSourceResult = immutableDataTypeDecoratorRatingCharacteristics.source();
    EntityReference actualTargetResult = immutableDataTypeDecoratorRatingCharacteristics.target();

    // Assert
    assertTrue(actualSourceResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetResult instanceof ImmutableEntityReference);
    assertEquals(
        "DataTypeDecoratorRatingCharacteristics{source=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " target=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, dataTypeId=1, sourceOutboundRating=42,"
            + " targetInboundRating=42, outboundMessage=Outbound Message, outboundMessageSeverity=NONE, inboundMessage"
            + "=Inbound Message, inboundMessageSeverity=NONE}",
        actualToStringResult);
    assertEquals("Inbound Message", actualInboundMessageResult);
    assertEquals("Outbound Message", actualOutboundMessageResult);
    assertEquals(1L, actualDataTypeIdResult);
    assertEquals(actualSourceResult, actualTargetResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#inboundMessageSeverity()}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#inboundMessageSeverity()}
   */
  @Test
  @DisplayName("Test inboundMessageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MessageSeverity ImmutableDataTypeDecoratorRatingCharacteristics.inboundMessageSeverity()"
  })
  void testInboundMessageSeverity() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertEquals(
        MessageSeverity.NONE,
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build()
            .inboundMessageSeverity());
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   *
   * <p>Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setInboundMessage(String)}
   *   <li>{@link Json#setInboundMessageSeverity(MessageSeverity)}
   *   <li>{@link Json#setOutboundMessage(String)}
   *   <li>{@link Json#setOutboundMessageSeverity(MessageSeverity)}
   *   <li>{@link Json#setSource(EntityReference)}
   *   <li>{@link Json#setSourceOutboundRating(AuthoritativenessRatingValue)}
   *   <li>{@link Json#setTarget(EntityReference)}
   *   <li>{@link Json#setTargetInboundRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setInboundMessage(String)",
    "void Json.setInboundMessageSeverity(MessageSeverity)",
    "void Json.setOutboundMessage(String)",
    "void Json.setOutboundMessageSeverity(MessageSeverity)",
    "void Json.setSource(EntityReference)",
    "void Json.setSourceOutboundRating(AuthoritativenessRatingValue)",
    "void Json.setTarget(EntityReference)",
    "void Json.setTargetInboundRating(AuthoritativenessRatingValue)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setInboundMessage("Inbound Message");
    actualJson.setInboundMessageSeverity(MessageSeverity.NONE);
    actualJson.setOutboundMessage("Outbound Message");
    actualJson.setOutboundMessageSeverity(MessageSeverity.NONE);
    actualJson.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setSourceOutboundRating(AuthoritativenessRatingValue.of("42"));
    actualJson.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setTargetInboundRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals("42", actualJson.sourceOutboundRating.value());
    assertEquals("42", actualJson.targetInboundRating.value());
  }

  /**
   * Test Json {@link Json#inboundMessage()}.
   *
   * <p>Method under test: {@link Json#inboundMessage()}
   */
  @Test
  @DisplayName("Test Json inboundMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.inboundMessage()"})
  void testJsonInboundMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inboundMessage());
  }

  /**
   * Test Json {@link Json#inboundMessageSeverity()}.
   *
   * <p>Method under test: {@link Json#inboundMessageSeverity()}
   */
  @Test
  @DisplayName("Test Json inboundMessageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity Json.inboundMessageSeverity()"})
  void testJsonInboundMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inboundMessageSeverity());
  }

  /**
   * Test Json {@link Json#outboundMessage()}.
   *
   * <p>Method under test: {@link Json#outboundMessage()}
   */
  @Test
  @DisplayName("Test Json outboundMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.outboundMessage()"})
  void testJsonOutboundMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().outboundMessage());
  }

  /**
   * Test Json {@link Json#outboundMessageSeverity()}.
   *
   * <p>Method under test: {@link Json#outboundMessageSeverity()}
   */
  @Test
  @DisplayName("Test Json outboundMessageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity Json.outboundMessageSeverity()"})
  void testJsonOutboundMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().outboundMessageSeverity());
  }

  /**
   * Test Json {@link Json#setDataTypeId(long)}.
   *
   * <p>Method under test: {@link Json#setDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDataTypeId(long)"})
  void testJsonSetDataTypeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#source()}.
   *
   * <p>Method under test: {@link Json#source()}
   */
  @Test
  @DisplayName("Test Json source()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().source());
  }

  /**
   * Test Json {@link Json#sourceOutboundRating()}.
   *
   * <p>Method under test: {@link Json#sourceOutboundRating()}
   */
  @Test
  @DisplayName("Test Json sourceOutboundRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AuthoritativenessRatingValue Json.sourceOutboundRating()"})
  void testJsonSourceOutboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sourceOutboundRating());
  }

  /**
   * Test Json {@link Json#target()}.
   *
   * <p>Method under test: {@link Json#target()}
   */
  @Test
  @DisplayName("Test Json target()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().target());
  }

  /**
   * Test Json {@link Json#targetInboundRating()}.
   *
   * <p>Method under test: {@link Json#targetInboundRating()}
   */
  @Test
  @DisplayName("Test Json targetInboundRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AuthoritativenessRatingValue Json.targetInboundRating()"})
  void testJsonTargetInboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetInboundRating());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#outboundMessageSeverity()}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#outboundMessageSeverity()}
   */
  @Test
  @DisplayName("Test outboundMessageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MessageSeverity ImmutableDataTypeDecoratorRatingCharacteristics.outboundMessageSeverity()"
  })
  void testOutboundMessageSeverity() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertEquals(
        MessageSeverity.NONE,
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build()
            .outboundMessageSeverity());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#sourceOutboundRating()}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#sourceOutboundRating()}
   */
  @Test
  @DisplayName("Test sourceOutboundRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AuthoritativenessRatingValue ImmutableDataTypeDecoratorRatingCharacteristics.sourceOutboundRating()"
  })
  void testSourceOutboundRating() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AuthoritativenessRatingValue sourceOutboundRating = AuthoritativenessRatingValue.of("42");

    Builder sourceOutboundRatingResult = sourceResult.sourceOutboundRating(sourceOutboundRating);

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    AuthoritativenessRatingValue actualSourceOutboundRatingResult =
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build()
            .sourceOutboundRating();

    // Assert
    assertEquals("42", actualSourceOutboundRatingResult.value());
    assertSame(sourceOutboundRating, actualSourceOutboundRatingResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#targetInboundRating()}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#targetInboundRating()}
   */
  @Test
  @DisplayName("Test targetInboundRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AuthoritativenessRatingValue ImmutableDataTypeDecoratorRatingCharacteristics.targetInboundRating()"
  })
  void testTargetInboundRating() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AuthoritativenessRatingValue targetInboundRating = AuthoritativenessRatingValue.of("42");

    // Act
    AuthoritativenessRatingValue actualTargetInboundRatingResult =
        targetResult.targetInboundRating(targetInboundRating).build().targetInboundRating();

    // Assert
    assertEquals("42", actualTargetInboundRatingResult.value());
    assertSame(targetInboundRating, actualTargetInboundRatingResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#withDataTypeId(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withDataTypeId(long)"
  })
  void testWithDataTypeId() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(42L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithDataTypeIdResult =
        immutableDataTypeDecoratorRatingCharacteristics.withDataTypeId(42L);

    // Assert
    assertSame(immutableDataTypeDecoratorRatingCharacteristics, actualWithDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#withDataTypeId(long)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(long); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withDataTypeId(long)"
  })
  void testWithDataTypeId_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithDataTypeIdResult =
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build()
            .withDataTypeId(42L);

    // Assert
    EntityReference sourceResult2 = actualWithDataTypeIdResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithDataTypeIdResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    AuthoritativenessRatingValue sourceOutboundRatingResult2 =
        actualWithDataTypeIdResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult2.value());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertEquals(sourceOutboundRatingResult2, actualWithDataTypeIdResult.targetInboundRating());
    assertEquals(sourceResult2, targetResult2);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#withInboundMessage(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withInboundMessage(String)}
   */
  @Test
  @DisplayName("Test withInboundMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withInboundMessage(String)"
  })
  void testWithInboundMessage() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("42")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithInboundMessageResult =
        immutableDataTypeDecoratorRatingCharacteristics.withInboundMessage("42");

    // Assert
    assertSame(immutableDataTypeDecoratorRatingCharacteristics, actualWithInboundMessageResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withInboundMessageSeverity(MessageSeverity)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withInboundMessageSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName("Test withInboundMessageSeverity(MessageSeverity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withInboundMessageSeverity(MessageSeverity)"
  })
  void testWithInboundMessageSeverity() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithInboundMessageSeverityResult =
        immutableDataTypeDecoratorRatingCharacteristics.withInboundMessageSeverity(
            MessageSeverity.NONE);

    // Assert
    assertSame(
        immutableDataTypeDecoratorRatingCharacteristics, actualWithInboundMessageSeverityResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withInboundMessageSeverity(MessageSeverity)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withInboundMessageSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName(
      "Test withInboundMessageSeverity(MessageSeverity); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withInboundMessageSeverity(MessageSeverity)"
  })
  void testWithInboundMessageSeverity_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.INFORMATION)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithInboundMessageSeverityResult =
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build()
            .withInboundMessageSeverity(MessageSeverity.NONE);

    // Assert
    EntityReference sourceResult2 = actualWithInboundMessageSeverityResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithInboundMessageSeverityResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    AuthoritativenessRatingValue sourceOutboundRatingResult2 =
        actualWithInboundMessageSeverityResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult2.value());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertEquals(
        sourceOutboundRatingResult2, actualWithInboundMessageSeverityResult.targetInboundRating());
    assertEquals(sourceResult2, targetResult2);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#withInboundMessage(String)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withInboundMessage(String)}
   */
  @Test
  @DisplayName("Test withInboundMessage(String); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withInboundMessage(String)"
  })
  void testWithInboundMessage_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithInboundMessageResult =
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build()
            .withInboundMessage("42");

    // Assert
    EntityReference sourceResult2 = actualWithInboundMessageResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithInboundMessageResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    AuthoritativenessRatingValue sourceOutboundRatingResult2 =
        actualWithInboundMessageResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult2.value());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertEquals(sourceOutboundRatingResult2, actualWithInboundMessageResult.targetInboundRating());
    assertEquals(sourceResult2, targetResult2);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#withOutboundMessage(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withOutboundMessage(String)}
   */
  @Test
  @DisplayName("Test withOutboundMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withOutboundMessage(String)"
  })
  void testWithOutboundMessage() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("42")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithOutboundMessageResult =
        immutableDataTypeDecoratorRatingCharacteristics.withOutboundMessage("42");

    // Assert
    assertSame(immutableDataTypeDecoratorRatingCharacteristics, actualWithOutboundMessageResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withOutboundMessageSeverity(MessageSeverity)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withOutboundMessageSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName("Test withOutboundMessageSeverity(MessageSeverity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withOutboundMessageSeverity(MessageSeverity)"
  })
  void testWithOutboundMessageSeverity() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithOutboundMessageSeverityResult =
        immutableDataTypeDecoratorRatingCharacteristics.withOutboundMessageSeverity(
            MessageSeverity.NONE);

    // Assert
    assertSame(
        immutableDataTypeDecoratorRatingCharacteristics, actualWithOutboundMessageSeverityResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withOutboundMessageSeverity(MessageSeverity)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withOutboundMessageSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName(
      "Test withOutboundMessageSeverity(MessageSeverity); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withOutboundMessageSeverity(MessageSeverity)"
  })
  void testWithOutboundMessageSeverity_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.INFORMATION);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithOutboundMessageSeverityResult =
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build()
            .withOutboundMessageSeverity(MessageSeverity.NONE);

    // Assert
    EntityReference sourceResult2 = actualWithOutboundMessageSeverityResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithOutboundMessageSeverityResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    AuthoritativenessRatingValue sourceOutboundRatingResult2 =
        actualWithOutboundMessageSeverityResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult2.value());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertEquals(
        sourceOutboundRatingResult2, actualWithOutboundMessageSeverityResult.targetInboundRating());
    assertEquals(sourceResult2, targetResult2);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#withOutboundMessage(String)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withOutboundMessage(String)}
   */
  @Test
  @DisplayName("Test withOutboundMessage(String); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withOutboundMessage(String)"
  })
  void testWithOutboundMessage_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithOutboundMessageResult =
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build()
            .withOutboundMessage("42");

    // Assert
    EntityReference sourceResult2 = actualWithOutboundMessageResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithOutboundMessageResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    AuthoritativenessRatingValue sourceOutboundRatingResult2 =
        actualWithOutboundMessageResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult2.value());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertEquals(
        sourceOutboundRatingResult2, actualWithOutboundMessageResult.targetInboundRating());
    assertEquals(sourceResult2, targetResult2);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#withSource(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withSource(EntityReference)}
   */
  @Test
  @DisplayName("Test withSource(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withSource(EntityReference)"
  })
  void testWithSource() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithSourceResult =
        immutableDataTypeDecoratorRatingCharacteristics.withSource(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDataTypeDecoratorRatingCharacteristics, actualWithSourceResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withSourceOutboundRating(AuthoritativenessRatingValue)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withSourceOutboundRating(AuthoritativenessRatingValue)}
   */
  @Test
  @DisplayName("Test withSourceOutboundRating(AuthoritativenessRatingValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withSourceOutboundRating(AuthoritativenessRatingValue)"
  })
  void testWithSourceOutboundRating() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithSourceOutboundRatingResult =
        immutableDataTypeDecoratorRatingCharacteristics.withSourceOutboundRating(
            AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals(
        immutableDataTypeDecoratorRatingCharacteristics, actualWithSourceOutboundRatingResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#withTarget(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withTarget(EntityReference)}
   */
  @Test
  @DisplayName("Test withTarget(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withTarget(EntityReference)"
  })
  void testWithTarget() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithTargetResult =
        immutableDataTypeDecoratorRatingCharacteristics.withTarget(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDataTypeDecoratorRatingCharacteristics, actualWithTargetResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withTargetInboundRating(AuthoritativenessRatingValue)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristics#withTargetInboundRating(AuthoritativenessRatingValue)}
   */
  @Test
  @DisplayName("Test withTargetInboundRating(AuthoritativenessRatingValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristics ImmutableDataTypeDecoratorRatingCharacteristics.withTargetInboundRating(AuthoritativenessRatingValue)"
  })
  void testWithTargetInboundRating() {
    // Arrange
    Builder outboundMessageSeverityResult =
        ImmutableDataTypeDecoratorRatingCharacteristics.builder()
            .dataTypeId(1L)
            .inboundMessage("Inbound Message")
            .inboundMessageSeverity(MessageSeverity.NONE)
            .outboundMessage("Outbound Message")
            .outboundMessageSeverity(MessageSeverity.NONE);

    Builder sourceResult =
        outboundMessageSeverityResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder sourceOutboundRatingResult =
        sourceResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristics
        immutableDataTypeDecoratorRatingCharacteristics =
            targetResult.targetInboundRating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualWithTargetInboundRatingResult =
        immutableDataTypeDecoratorRatingCharacteristics.withTargetInboundRating(
            AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals(
        immutableDataTypeDecoratorRatingCharacteristics, actualWithTargetInboundRatingResult);
  }
}
