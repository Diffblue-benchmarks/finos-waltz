package org.finos.waltz.model.flow_classification_rule;

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
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleVantagePointDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#builder()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#dataTypeId(Long)}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#message(String)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleVantagePoint#messageSeverity(MessageSeverity)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowClassificationRuleVantagePoint.Builder actualMessageResult = ImmutableFlowClassificationRuleVantagePoint
        .builder()
        .dataTypeId(1L)
        .message("Not all who wander are lost");

    // Assert
    assertSame(actualMessageResult, actualMessageResult.messageSeverity(MessageSeverity.NONE));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#classificationCode(String)}
   */
  @Test
  void testBuilderClassificationCode() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationCode("Classification Code"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#dataTypeRank(int)}
   */
  @Test
  void testBuilderDataTypeRank() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeRank(1));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();
    FlowClassificationRuleVantagePoint instance = mock(FlowClassificationRuleVantagePoint.class);
    when(instance.vantagePointRank()).thenThrow(new IllegalStateException("instance"));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();
    FlowClassificationRuleVantagePoint instance = mock(FlowClassificationRuleVantagePoint.class);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.ruleId()).thenReturn(1L);
    when(instance.classificationCode()).thenReturn("Classification Code");
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowClassificationRuleVantagePoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classificationCode();
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).ruleId();
    verify(instance).subjectReference();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
    ImmutableFlowClassificationRuleVantagePoint buildResult = builderResult.build();
    assertEquals("Classification Code", buildResult.classificationCode());
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals(1, buildResult.dataTypeRank());
    assertEquals(1, buildResult.vantagePointRank());
    assertEquals(1L, buildResult.dataTypeId().longValue());
    assertEquals(1L, buildResult.ruleId().longValue());
    assertEquals(MessageSeverity.NONE, buildResult.messageSeverity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();
    FlowClassificationRuleVantagePoint instance = mock(FlowClassificationRuleVantagePoint.class);
    when(instance.message()).thenThrow(new IllegalStateException("instance"));
    when(instance.ruleId()).thenReturn(1L);
    when(instance.classificationCode()).thenReturn("Classification Code");
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).classificationCode();
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).message();
    verify(instance).ruleId();
    verify(instance).subjectReference();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();
    FlowClassificationRuleVantagePoint instance = mock(FlowClassificationRuleVantagePoint.class);
    when(instance.message()).thenReturn(null);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.ruleId()).thenReturn(1L);
    when(instance.classificationCode()).thenReturn("Classification Code");
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowClassificationRuleVantagePoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classificationCode();
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).ruleId();
    verify(instance).subjectReference();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
    ImmutableFlowClassificationRuleVantagePoint buildResult = builderResult.build();
    assertEquals("Classification Code", buildResult.classificationCode());
    assertNull(buildResult.message());
    assertEquals(1, buildResult.dataTypeRank());
    assertEquals(1, buildResult.vantagePointRank());
    assertEquals(1L, buildResult.dataTypeId().longValue());
    assertEquals(1L, buildResult.ruleId().longValue());
    assertEquals(MessageSeverity.NONE, buildResult.messageSeverity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#ruleId(Long)}
   */
  @Test
  void testBuilderRuleId() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ruleId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#subjectReference(EntityReference)}
   */
  @Test
  void testBuilderSubjectReference() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#vantagePoint(EntityReference)}
   */
  @Test
  void testBuilderVantagePoint() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePoint(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Builder#vantagePointRank(int)}
   */
  @Test
  void testBuilderVantagePointRank() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Builder builderResult = ImmutableFlowClassificationRuleVantagePoint
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePointRank(1));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint#copyOf(FlowClassificationRuleVantagePoint)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowClassificationRuleVantagePoint instance = mock(FlowClassificationRuleVantagePoint.class);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.ruleId()).thenReturn(1L);
    when(instance.classificationCode()).thenReturn("Classification Code");
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualCopyOfResult = ImmutableFlowClassificationRuleVantagePoint
        .copyOf(instance);

    // Assert
    verify(instance).classificationCode();
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).ruleId();
    verify(instance).subjectReference();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
    assertEquals("Classification Code", actualCopyOfResult.classificationCode());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(1, actualCopyOfResult.dataTypeRank());
    assertEquals(1, actualCopyOfResult.vantagePointRank());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(1L, actualCopyOfResult.ruleId().longValue());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint#copyOf(FlowClassificationRuleVantagePoint)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FlowClassificationRuleVantagePoint instance = mock(FlowClassificationRuleVantagePoint.class);
    when(instance.message()).thenReturn(null);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.ruleId()).thenReturn(1L);
    when(instance.classificationCode()).thenReturn("Classification Code");
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualCopyOfResult = ImmutableFlowClassificationRuleVantagePoint
        .copyOf(instance);

    // Assert
    verify(instance).classificationCode();
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).ruleId();
    verify(instance).subjectReference();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
    assertEquals("Classification Code", actualCopyOfResult.classificationCode());
    assertNull(actualCopyOfResult.message());
    assertEquals(1, actualCopyOfResult.dataTypeRank());
    assertEquals(1, actualCopyOfResult.vantagePointRank());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(1L, actualCopyOfResult.ruleId().longValue());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint#copyOf(FlowClassificationRuleVantagePoint)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    FlowClassificationRuleVantagePoint instance = mock(FlowClassificationRuleVantagePoint.class);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.ruleId()).thenReturn(1L);
    when(instance.classificationCode()).thenReturn("Classification Code");
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(null);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualCopyOfResult = ImmutableFlowClassificationRuleVantagePoint
        .copyOf(instance);

    // Assert
    verify(instance).classificationCode();
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).ruleId();
    verify(instance).subjectReference();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
    assertEquals("Classification Code", actualCopyOfResult.classificationCode());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertNull(actualCopyOfResult.dataTypeId());
    assertEquals(1, actualCopyOfResult.dataTypeRank());
    assertEquals(1, actualCopyOfResult.vantagePointRank());
    assertEquals(1L, actualCopyOfResult.ruleId().longValue());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#classificationCode()}
   */
  @Test
  void testJsonClassificationCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).classificationCode());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).dataTypeId());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#dataTypeRank()}
   */
  @Test
  void testJsonDataTypeRank() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).dataTypeRank());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json}
   *   <li>
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setClassificationCode(String)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setDataTypeId(Long)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setMessage(String)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setMessageSeverity(MessageSeverity)}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint.Json#setRuleId(Long)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setSubjectReference(EntityReference)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setVantagePoint(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableFlowClassificationRuleVantagePoint.Json actualJson = new ImmutableFlowClassificationRuleVantagePoint.Json();
    actualJson.setClassificationCode("Classification Code");
    actualJson.setDataTypeId(1L);
    actualJson.setMessage("Not all who wander are lost");
    actualJson.setMessageSeverity(MessageSeverity.NONE);
    actualJson.setRuleId(1L);
    actualJson.setSubjectReference(null);
    actualJson.setVantagePoint(null);

    // Assert
    assertEquals(1L, actualJson.dataTypeId.longValue());
    assertEquals(1L, actualJson.ruleId.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).message());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#messageSeverity()}
   */
  @Test
  void testJsonMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).messageSeverity());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#ruleId()}
   */
  @Test
  void testJsonRuleId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).ruleId());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setDataTypeRank(int)}
   */
  @Test
  void testJsonSetDataTypeRank() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Json json = new ImmutableFlowClassificationRuleVantagePoint.Json();

    // Act
    json.setDataTypeRank(1);

    // Assert
    assertEquals(1, json.dataTypeRank);
    assertTrue(json.dataTypeRankIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setDataTypeRank(int)}
   */
  @Test
  void testJsonSetDataTypeRank2() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Json json = new ImmutableFlowClassificationRuleVantagePoint.Json();
    json.setVantagePoint(mock(EntityReference.class));

    // Act
    json.setDataTypeRank(1);

    // Assert
    assertEquals(1, json.dataTypeRank);
    assertTrue(json.dataTypeRankIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setVantagePointRank(int)}
   */
  @Test
  void testJsonSetVantagePointRank() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Json json = new ImmutableFlowClassificationRuleVantagePoint.Json();

    // Act
    json.setVantagePointRank(1);

    // Assert
    assertEquals(1, json.vantagePointRank);
    assertTrue(json.vantagePointRankIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#setVantagePointRank(int)}
   */
  @Test
  void testJsonSetVantagePointRank2() {
    // Arrange
    ImmutableFlowClassificationRuleVantagePoint.Json json = new ImmutableFlowClassificationRuleVantagePoint.Json();
    json.setVantagePoint(mock(EntityReference.class));

    // Act
    json.setVantagePointRank(1);

    // Assert
    assertEquals(1, json.vantagePointRank);
    assertTrue(json.vantagePointRankIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#subjectReference()}
   */
  @Test
  void testJsonSubjectReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).subjectReference());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#vantagePoint()}
   */
  @Test
  void testJsonVantagePoint() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).vantagePoint());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleVantagePoint.Json#vantagePointRank()}
   */
  @Test
  void testJsonVantagePointRank() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleVantagePoint.Json()).vantagePointRank());
  }
}
