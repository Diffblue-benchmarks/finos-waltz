package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristics.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristics.Json;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorRatingCharacteristicsDiffblueTest {
  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristics#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#builder()}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#inboundMessage(String)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#inboundMessageSeverity(MessageSeverity)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#outboundMessage(String)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#outboundMessageSeverity(MessageSeverity)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#sourceOutboundRating(AuthoritativenessRatingValue)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#targetInboundRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDataTypeDecoratorRatingCharacteristics Builder.build()",
      "Builder Builder.inboundMessage(String)", "Builder Builder.inboundMessageSeverity(MessageSeverity)",
      "Builder Builder.outboundMessage(String)", "Builder Builder.outboundMessageSeverity(MessageSeverity)",
      "Builder Builder.sourceOutboundRating(AuthoritativenessRatingValue)",
      "Builder Builder.targetInboundRating(AuthoritativenessRatingValue)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualOutboundMessageSeverityResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder()
        .inboundMessage("Inbound Message")
        .inboundMessageSeverity(MessageSeverity.NONE)
        .outboundMessage("Outbound Message")
        .outboundMessageSeverity(MessageSeverity.NONE);
    Builder actualSourceOutboundRatingResult = actualOutboundMessageSeverityResult
        .sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertSame(actualSourceOutboundRatingResult,
        actualSourceOutboundRatingResult.targetInboundRating(AuthoritativenessRatingValue.of("42")));
  }

  /**
   * Test Builder {@link Builder#dataTypeId(long)}.
   * <p>
   * Method under test: {@link Builder#dataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeId(long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeId(1L));
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}.
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristics)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristics)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}.
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristics)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristics)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenThrow(new IllegalStateException("instance"));
    when(instance.outboundMessage()).thenReturn("Outbound Message");
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.targetInboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.sourceOutboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeId();
    verify(instance).inboundMessage();
    verify(instance).outboundMessage();
    verify(instance).outboundMessageSeverity();
    verify(instance).source();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}.
   * <ul>
   *   <li>Then return build inboundMessage is {@code Inbound Message}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristics); then return build inboundMessage is 'Inbound Message'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristics)"})
  void testBuilderFrom_thenReturnBuildInboundMessageIsInboundMessage() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn("Inbound Message");
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn("Outbound Message");
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.targetInboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.sourceOutboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).inboundMessage();
    verify(instance).inboundMessageSeverity();
    verify(instance).outboundMessage();
    verify(instance).outboundMessageSeverity();
    verify(instance).source();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult = actualFromResult.build();
    assertEquals("Inbound Message", buildResult.inboundMessage());
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult2 = builderResult.build();
    assertEquals("Inbound Message", buildResult2.inboundMessage());
    assertEquals("Outbound Message", buildResult.outboundMessage());
    assertEquals("Outbound Message", buildResult2.outboundMessage());
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}.
   * <ul>
   *   <li>Then return build inboundMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristics); then return build inboundMessage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristics)"})
  void testBuilderFrom_thenReturnBuildInboundMessageIsNull() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn(null);
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn("Outbound Message");
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.targetInboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.sourceOutboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).inboundMessage();
    verify(instance).inboundMessageSeverity();
    verify(instance).outboundMessage();
    verify(instance).outboundMessageSeverity();
    verify(instance).source();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult = actualFromResult.build();
    assertEquals("Outbound Message", buildResult.outboundMessage());
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult2 = builderResult.build();
    assertEquals("Outbound Message", buildResult2.outboundMessage());
    assertNull(buildResult.inboundMessage());
    assertNull(buildResult2.inboundMessage());
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}.
   * <ul>
   *   <li>Then return build outboundMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristics); then return build outboundMessage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristics)"})
  void testBuilderFrom_thenReturnBuildOutboundMessageIsNull() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn("Inbound Message");
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn(null);
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.targetInboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.sourceOutboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).inboundMessage();
    verify(instance).inboundMessageSeverity();
    verify(instance).outboundMessage();
    verify(instance).outboundMessageSeverity();
    verify(instance).source();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult = actualFromResult.build();
    assertEquals("Inbound Message", buildResult.inboundMessage());
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult2 = builderResult.build();
    assertEquals("Inbound Message", buildResult2.inboundMessage());
    assertNull(buildResult.outboundMessage());
    assertNull(buildResult2.outboundMessage());
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   * <p>
   * Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setInboundMessage(String)",
      "void Json.setInboundMessageSeverity(MessageSeverity)", "void Json.setOutboundMessage(String)",
      "void Json.setOutboundMessageSeverity(MessageSeverity)", "void Json.setSource(EntityReference)",
      "void Json.setSourceOutboundRating(AuthoritativenessRatingValue)", "void Json.setTarget(EntityReference)",
      "void Json.setTargetInboundRating(AuthoritativenessRatingValue)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setInboundMessage("Inbound Message");
    actualJson.setInboundMessageSeverity(MessageSeverity.NONE);
    actualJson.setOutboundMessage("Outbound Message");
    actualJson.setOutboundMessageSeverity(MessageSeverity.NONE);
    actualJson.setSource(null);
    actualJson.setSourceOutboundRating(AuthoritativenessRatingValue.of("42"));
    actualJson.setTarget(null);
    actualJson.setTargetInboundRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals("42", actualJson.sourceOutboundRating.value());
    assertEquals("42", actualJson.targetInboundRating.value());
  }

  /**
   * Test Json {@link Json#inboundMessage()}.
   * <p>
   * Method under test: {@link Json#inboundMessage()}
   */
  @Test
  @DisplayName("Test Json inboundMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.inboundMessage()"})
  void testJsonInboundMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inboundMessage());
  }

  /**
   * Test Json {@link Json#inboundMessageSeverity()}.
   * <p>
   * Method under test: {@link Json#inboundMessageSeverity()}
   */
  @Test
  @DisplayName("Test Json inboundMessageSeverity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MessageSeverity Json.inboundMessageSeverity()"})
  void testJsonInboundMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inboundMessageSeverity());
  }

  /**
   * Test Json {@link Json#outboundMessage()}.
   * <p>
   * Method under test: {@link Json#outboundMessage()}
   */
  @Test
  @DisplayName("Test Json outboundMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.outboundMessage()"})
  void testJsonOutboundMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).outboundMessage());
  }

  /**
   * Test Json {@link Json#outboundMessageSeverity()}.
   * <p>
   * Method under test: {@link Json#outboundMessageSeverity()}
   */
  @Test
  @DisplayName("Test Json outboundMessageSeverity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MessageSeverity Json.outboundMessageSeverity()"})
  void testJsonOutboundMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).outboundMessageSeverity());
  }

  /**
   * Test Json {@link Json#setDataTypeId(long)}.
   * <p>
   * Method under test: {@link Json#setDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setDataTypeId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#source()}
   */
  @Test
  @DisplayName("Test Json source()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).source());
  }

  /**
   * Test Json {@link Json#sourceOutboundRating()}.
   * <p>
   * Method under test: {@link Json#sourceOutboundRating()}
   */
  @Test
  @DisplayName("Test Json sourceOutboundRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuthoritativenessRatingValue Json.sourceOutboundRating()"})
  void testJsonSourceOutboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sourceOutboundRating());
  }

  /**
   * Test Json {@link Json#target()}.
   * <p>
   * Method under test: {@link Json#target()}
   */
  @Test
  @DisplayName("Test Json target()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).target());
  }

  /**
   * Test Json {@link Json#targetInboundRating()}.
   * <p>
   * Method under test: {@link Json#targetInboundRating()}
   */
  @Test
  @DisplayName("Test Json targetInboundRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuthoritativenessRatingValue Json.targetInboundRating()"})
  void testJsonTargetInboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetInboundRating());
  }
}
