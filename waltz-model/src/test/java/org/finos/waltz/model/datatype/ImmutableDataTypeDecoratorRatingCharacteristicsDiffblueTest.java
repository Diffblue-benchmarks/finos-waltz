package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorRatingCharacteristicsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristics#builder()}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#inboundMessage(String)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#inboundMessageSeverity(MessageSeverity)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#outboundMessage(String)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#outboundMessageSeverity(MessageSeverity)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#sourceOutboundRating(AuthoritativenessRatingValue)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#targetInboundRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder actualOutboundMessageSeverityResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder()
        .inboundMessage("Inbound Message")
        .inboundMessageSeverity(MessageSeverity.NONE)
        .outboundMessage("Outbound Message")
        .outboundMessageSeverity(MessageSeverity.NONE);
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder actualSourceOutboundRatingResult = actualOutboundMessageSeverityResult
        .sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertSame(actualSourceOutboundRatingResult,
        actualSourceOutboundRatingResult.targetInboundRating(AuthoritativenessRatingValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Builder#dataTypeId(long)}
   */
  @Test
  void testBuilderDataTypeId() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn("Inbound Message");
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn("Outbound Message");
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.dataTypeId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult = builderResult.build();
    assertEquals("Inbound Message", buildResult.inboundMessage());
    assertEquals("Outbound Message", buildResult.outboundMessage());
    assertEquals(1L, buildResult.dataTypeId());
    assertEquals(MessageSeverity.NONE, buildResult.inboundMessageSeverity());
    assertEquals(MessageSeverity.NONE, buildResult.outboundMessageSeverity());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.sourceOutboundRating());
    assertSame(ofResult, buildResult.targetInboundRating());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder();
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
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn(null);
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn("Outbound Message");
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.dataTypeId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult = builderResult.build();
    assertEquals("Outbound Message", buildResult.outboundMessage());
    assertNull(buildResult.inboundMessage());
    assertEquals(1L, buildResult.dataTypeId());
    assertEquals(MessageSeverity.NONE, buildResult.inboundMessageSeverity());
    assertEquals(MessageSeverity.NONE, buildResult.outboundMessageSeverity());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.sourceOutboundRating());
    assertSame(ofResult, buildResult.targetInboundRating());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Builder#from(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder();
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn("Inbound Message");
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn(null);
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.dataTypeId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableDataTypeDecoratorRatingCharacteristics buildResult = builderResult.build();
    assertEquals("Inbound Message", buildResult.inboundMessage());
    assertNull(buildResult.outboundMessage());
    assertEquals(1L, buildResult.dataTypeId());
    assertEquals(MessageSeverity.NONE, buildResult.inboundMessageSeverity());
    assertEquals(MessageSeverity.NONE, buildResult.outboundMessageSeverity());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.sourceOutboundRating());
    assertSame(ofResult, buildResult.targetInboundRating());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Builder#source(EntityReference)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Builder#target(EntityReference)}
   */
  @Test
  void testBuilderTarget() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#copyOf(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn("Inbound Message");
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn("Outbound Message");
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.dataTypeId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualCopyOfResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .copyOf(instance);

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
    AuthoritativenessRatingValue sourceOutboundRatingResult = actualCopyOfResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult.value());
    AuthoritativenessRatingValue targetInboundRatingResult = actualCopyOfResult.targetInboundRating();
    assertEquals("42", targetInboundRatingResult.value());
    assertEquals("Inbound Message", actualCopyOfResult.inboundMessage());
    assertEquals("Outbound Message", actualCopyOfResult.outboundMessage());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.inboundMessageSeverity());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.outboundMessageSeverity());
    assertSame(ofResult2, sourceOutboundRatingResult);
    assertSame(ofResult, targetInboundRatingResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#copyOf(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn(null);
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn("Outbound Message");
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.dataTypeId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualCopyOfResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .copyOf(instance);

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
    AuthoritativenessRatingValue sourceOutboundRatingResult = actualCopyOfResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult.value());
    AuthoritativenessRatingValue targetInboundRatingResult = actualCopyOfResult.targetInboundRating();
    assertEquals("42", targetInboundRatingResult.value());
    assertEquals("Outbound Message", actualCopyOfResult.outboundMessage());
    assertNull(actualCopyOfResult.inboundMessage());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.inboundMessageSeverity());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.outboundMessageSeverity());
    assertSame(ofResult2, sourceOutboundRatingResult);
    assertSame(ofResult, targetInboundRatingResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics#copyOf(DataTypeDecoratorRatingCharacteristics)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    DataTypeDecoratorRatingCharacteristics instance = mock(DataTypeDecoratorRatingCharacteristics.class);
    when(instance.inboundMessage()).thenReturn("Inbound Message");
    when(instance.inboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.outboundMessage()).thenReturn(null);
    when(instance.outboundMessageSeverity()).thenReturn(MessageSeverity.NONE);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.dataTypeId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristics actualCopyOfResult = ImmutableDataTypeDecoratorRatingCharacteristics
        .copyOf(instance);

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
    AuthoritativenessRatingValue sourceOutboundRatingResult = actualCopyOfResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult.value());
    AuthoritativenessRatingValue targetInboundRatingResult = actualCopyOfResult.targetInboundRating();
    assertEquals("42", targetInboundRatingResult.value());
    assertEquals("Inbound Message", actualCopyOfResult.inboundMessage());
    assertNull(actualCopyOfResult.outboundMessage());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.inboundMessageSeverity());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.outboundMessageSeverity());
    assertSame(ofResult2, sourceOutboundRatingResult);
    assertSame(ofResult, targetInboundRatingResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).dataTypeId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setInboundMessage(String)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setInboundMessageSeverity(MessageSeverity)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setOutboundMessage(String)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setOutboundMessageSeverity(MessageSeverity)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setSource(EntityReference)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setSourceOutboundRating(AuthoritativenessRatingValue)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setTarget(EntityReference)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setTargetInboundRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDataTypeDecoratorRatingCharacteristics.Json actualJson = new ImmutableDataTypeDecoratorRatingCharacteristics.Json();
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
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#inboundMessage()}
   */
  @Test
  void testJsonInboundMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).inboundMessage());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#inboundMessageSeverity()}
   */
  @Test
  void testJsonInboundMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).inboundMessageSeverity());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#outboundMessage()}
   */
  @Test
  void testJsonOutboundMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).outboundMessage());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#outboundMessageSeverity()}
   */
  @Test
  void testJsonOutboundMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).outboundMessageSeverity());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setDataTypeId(long)}
   */
  @Test
  void testJsonSetDataTypeId() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Json json = new ImmutableDataTypeDecoratorRatingCharacteristics.Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#setDataTypeId(long)}
   */
  @Test
  void testJsonSetDataTypeId2() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristics.Json json = new ImmutableDataTypeDecoratorRatingCharacteristics.Json();
    json.setSource(mock(EntityReference.class));

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#source()}
   */
  @Test
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).source());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#sourceOutboundRating()}
   */
  @Test
  void testJsonSourceOutboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).sourceOutboundRating());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#target()}
   */
  @Test
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).target());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristics.Json#targetInboundRating()}
   */
  @Test
  void testJsonTargetInboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristics.Json()).targetInboundRating());
  }
}
