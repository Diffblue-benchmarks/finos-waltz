package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#builder()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#dataTypeId(Long)}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#description(String)}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#message(String)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleCreateCommand#severity(MessageSeverity)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowClassificationRuleCreateCommand.Builder actualMessageResult = ImmutableFlowClassificationRuleCreateCommand
        .builder()
        .dataTypeId(1L)
        .description("The characteristics of someone or something")
        .message("Not all who wander are lost");

    // Assert
    assertSame(actualMessageResult, actualMessageResult.severity(MessageSeverity.NONE));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Builder#classificationId(long)}
   */
  @Test
  void testBuilderClassificationId() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Builder builderResult = ImmutableFlowClassificationRuleCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Builder builderResult = ImmutableFlowClassificationRuleCreateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFlowClassificationRuleCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Builder builderResult = ImmutableFlowClassificationRuleCreateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableFlowClassificationRuleCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Builder builderResult = ImmutableFlowClassificationRuleCreateCommand
        .builder();
    FlowClassificationRuleCreateCommand instance = mock(FlowClassificationRuleCreateCommand.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).dataTypeId();
    verify(instance).parentReference();
    verify(instance).severity();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Builder builderResult = ImmutableFlowClassificationRuleCreateCommand
        .builder();
    FlowClassificationRuleCreateCommand instance = mock(FlowClassificationRuleCreateCommand.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));
    when(instance.severity()).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).dataTypeId();
    verify(instance).parentReference();
    verify(instance).severity();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Builder builderResult = ImmutableFlowClassificationRuleCreateCommand
        .builder();
    FlowClassificationRuleCreateCommand instance = mock(FlowClassificationRuleCreateCommand.class);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.classificationId()).thenReturn(1L);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).classificationId();
    verify(instance).dataTypeId();
    verify(instance).message();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).subjectReference();
    ImmutableFlowClassificationRuleCreateCommand buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.dataTypeId().longValue());
    assertEquals(1L, buildResult.classificationId());
    assertEquals(MessageSeverity.NONE, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Builder#parentReference(EntityReference)}
   */
  @Test
  void testBuilderParentReference() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Builder builderResult = ImmutableFlowClassificationRuleCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Builder#subjectReference(EntityReference)}
   */
  @Test
  void testBuilderSubjectReference() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Builder builderResult = ImmutableFlowClassificationRuleCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand#copyOf(FlowClassificationRuleCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowClassificationRuleCreateCommand instance = mock(FlowClassificationRuleCreateCommand.class);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.classificationId()).thenReturn(1L);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleCreateCommand actualCopyOfResult = ImmutableFlowClassificationRuleCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).classificationId();
    verify(instance).dataTypeId();
    verify(instance).message();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).subjectReference();
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(1L, actualCopyOfResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.severity());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#classificationId()}
   */
  @Test
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleCreateCommand.Json()).classificationId());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleCreateCommand.Json()).dataTypeId());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleCreateCommand.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json}
   *   <li>
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#setDataTypeId(Long)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#setDescription(String)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#setMessage(String)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#setParentReference(EntityReference)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#setSeverity(MessageSeverity)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#setSubjectReference(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableFlowClassificationRuleCreateCommand.Json actualJson = new ImmutableFlowClassificationRuleCreateCommand.Json();
    actualJson.setDataTypeId(1L);
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setMessage("Not all who wander are lost");
    actualJson.setParentReference(null);
    actualJson.setSeverity(MessageSeverity.NONE);
    actualJson.setSubjectReference(null);

    // Assert
    assertEquals(1L, actualJson.dataTypeId.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleCreateCommand.Json()).message());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#parentReference()}
   */
  @Test
  void testJsonParentReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleCreateCommand.Json()).parentReference());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#setClassificationId(long)}
   */
  @Test
  void testJsonSetClassificationId() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Json json = new ImmutableFlowClassificationRuleCreateCommand.Json();

    // Act
    json.setClassificationId(1L);

    // Assert
    assertEquals(1L, json.classificationId);
    assertTrue(json.classificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#setClassificationId(long)}
   */
  @Test
  void testJsonSetClassificationId2() {
    // Arrange
    ImmutableFlowClassificationRuleCreateCommand.Json json = new ImmutableFlowClassificationRuleCreateCommand.Json();
    json.setSubjectReference(mock(EntityReference.class));

    // Act
    json.setClassificationId(1L);

    // Assert
    assertEquals(1L, json.classificationId);
    assertTrue(json.classificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#severity()}
   */
  @Test
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleCreateCommand.Json()).severity());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleCreateCommand.Json#subjectReference()}
   */
  @Test
  void testJsonSubjectReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleCreateCommand.Json()).subjectReference());
  }
}
