package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristics.Builder;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataTypeDecoratorRatingCharacteristicsDiffblueTest {
  /**
   * Test {@link DataTypeDecoratorRatingCharacteristics#sourceOutboundRating()}.
   *
   * <p>Method under test: {@link DataTypeDecoratorRatingCharacteristics#sourceOutboundRating()}
   */
  @Test
  @DisplayName("Test sourceOutboundRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AuthoritativenessRatingValue DataTypeDecoratorRatingCharacteristics.sourceOutboundRating()"
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
   * Test {@link DataTypeDecoratorRatingCharacteristics#targetInboundRating()}.
   *
   * <p>Method under test: {@link DataTypeDecoratorRatingCharacteristics#targetInboundRating()}
   */
  @Test
  @DisplayName("Test targetInboundRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AuthoritativenessRatingValue DataTypeDecoratorRatingCharacteristics.targetInboundRating()"
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
   * Test {@link DataTypeDecoratorRatingCharacteristics#outboundMessageSeverity()}.
   *
   * <p>Method under test: {@link DataTypeDecoratorRatingCharacteristics#outboundMessageSeverity()}
   */
  @Test
  @DisplayName("Test outboundMessageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MessageSeverity DataTypeDecoratorRatingCharacteristics.outboundMessageSeverity()"
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
   * Test {@link DataTypeDecoratorRatingCharacteristics#inboundMessageSeverity()}.
   *
   * <p>Method under test: {@link DataTypeDecoratorRatingCharacteristics#inboundMessageSeverity()}
   */
  @Test
  @DisplayName("Test inboundMessageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MessageSeverity DataTypeDecoratorRatingCharacteristics.inboundMessageSeverity()"
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
}
