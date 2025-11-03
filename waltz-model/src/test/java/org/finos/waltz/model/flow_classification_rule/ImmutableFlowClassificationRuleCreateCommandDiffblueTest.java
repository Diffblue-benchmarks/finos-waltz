package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleCreateCommand.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleCreateCommandDiffblueTest {
  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#builder()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#dataTypeId(Long)}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#description(String)}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#message(String)}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#severity(MessageSeverity)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleCreateCommand Builder.build()", "Builder Builder.dataTypeId(Long)",
      "Builder Builder.description(String)", "Builder Builder.message(String)",
      "Builder Builder.severity(MessageSeverity)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualMessageResult = ImmutableFlowClassificationRuleCreateCommand.builder()
        .dataTypeId(1L)
        .description("The characteristics of someone or something")
        .message("Not all who wander are lost");

    // Assert
    assertSame(actualMessageResult, actualMessageResult.severity(MessageSeverity.NONE));
  }

  /**
   * Test Builder {@link Builder#classificationId(long)}.
   * <p>
   * Method under test: {@link Builder#classificationId(long)}
   */
  @Test
  @DisplayName("Test Builder classificationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.classificationId(long)"})
  void testBuilderClassificationId() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationId(1L));
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
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();
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
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleCreateCommand)} with {@code FlowClassificationRuleCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleCreateCommand) with 'FlowClassificationRuleCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleCreateCommand)"})
  void testBuilderFromWithFlowClassificationRuleCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();
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
   * Test Builder {@link Builder#from(FlowClassificationRuleCreateCommand)} with {@code FlowClassificationRuleCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleCreateCommand) with 'FlowClassificationRuleCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleCreateCommand)"})
  void testBuilderFromWithFlowClassificationRuleCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();
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
   * Test Builder {@link Builder#from(FlowClassificationRuleCreateCommand)} with {@code FlowClassificationRuleCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleCreateCommand) with 'FlowClassificationRuleCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleCreateCommand)"})
  void testBuilderFromWithFlowClassificationRuleCreateCommand3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();
    FlowClassificationRuleCreateCommand instance = mock(FlowClassificationRuleCreateCommand.class);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.classificationId()).thenReturn(1L);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#parentReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentReference(EntityReference)"})
  void testBuilderParentReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#subjectReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#subjectReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder subjectReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.subjectReference(EntityReference)"})
  void testBuilderSubjectReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectReference(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#classificationId()}.
   * <p>
   * Method under test: {@link Json#classificationId()}
   */
  @Test
  @DisplayName("Test Json classificationId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.classificationId()"})
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).classificationId());
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   * <p>
   * Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeId());
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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDataTypeId(Long)}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setMessage(String)}
   *   <li>{@link Json#setParentReference(EntityReference)}
   *   <li>{@link Json#setSeverity(MessageSeverity)}
   *   <li>{@link Json#setSubjectReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDataTypeId(Long)", "void Json.setDescription(String)",
      "void Json.setMessage(String)", "void Json.setParentReference(EntityReference)",
      "void Json.setSeverity(MessageSeverity)", "void Json.setSubjectReference(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).message());
  }

  /**
   * Test Json {@link Json#parentReference()}.
   * <p>
   * Method under test: {@link Json#parentReference()}
   */
  @Test
  @DisplayName("Test Json parentReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.parentReference()"})
  void testJsonParentReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentReference());
  }

  /**
   * Test Json {@link Json#setClassificationId(long)}.
   * <p>
   * Method under test: {@link Json#setClassificationId(long)}
   */
  @Test
  @DisplayName("Test Json setClassificationId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#severity()}
   */
  @Test
  @DisplayName("Test Json severity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MessageSeverity Json.severity()"})
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).severity());
  }

  /**
   * Test Json {@link Json#subjectReference()}.
   * <p>
   * Method under test: {@link Json#subjectReference()}
   */
  @Test
  @DisplayName("Test Json subjectReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.subjectReference()"})
  void testJsonSubjectReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).subjectReference());
  }
}
