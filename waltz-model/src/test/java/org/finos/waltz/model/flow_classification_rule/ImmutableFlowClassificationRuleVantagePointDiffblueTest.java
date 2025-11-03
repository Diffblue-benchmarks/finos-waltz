package org.finos.waltz.model.flow_classification_rule;

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
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleVantagePointDiffblueTest {
  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#builder()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#dataTypeId(Long)}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#message(String)}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#messageSeverity(MessageSeverity)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleVantagePoint Builder.build()", "Builder Builder.dataTypeId(Long)",
      "Builder Builder.message(String)", "Builder Builder.messageSeverity(MessageSeverity)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualMessageResult = ImmutableFlowClassificationRuleVantagePoint.builder()
        .dataTypeId(1L)
        .message("Not all who wander are lost");

    // Assert
    assertSame(actualMessageResult, actualMessageResult.messageSeverity(MessageSeverity.NONE));
  }

  /**
   * Test Builder {@link Builder#classificationCode(String)}.
   * <p>
   * Method under test: {@link Builder#classificationCode(String)}
   */
  @Test
  @DisplayName("Test Builder classificationCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.classificationCode(String)"})
  void testBuilderClassificationCode() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationCode("Classification Code"));
  }

  /**
   * Test Builder {@link Builder#dataTypeRank(int)}.
   * <p>
   * Method under test: {@link Builder#dataTypeRank(int)}
   */
  @Test
  @DisplayName("Test Builder dataTypeRank(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeRank(int)"})
  void testBuilderDataTypeRank() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeRank(1));
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleVantagePoint)}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleVantagePoint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleVantagePoint)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();
    FlowClassificationRuleVantagePoint instance = mock(FlowClassificationRuleVantagePoint.class);
    when(instance.vantagePointRank()).thenThrow(new IllegalStateException("instance"));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleVantagePoint)}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleVantagePoint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleVantagePoint)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();
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
   * Test Builder {@link Builder#from(FlowClassificationRuleVantagePoint)}.
   * <ul>
   *   <li>Then builder build message is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleVantagePoint); then builder build message is 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleVantagePoint)"})
  void testBuilderFrom_thenBuilderBuildMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(FlowClassificationRuleVantagePoint)}.
   * <ul>
   *   <li>Then builder build message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleVantagePoint); then builder build message is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleVantagePoint)"})
  void testBuilderFrom_thenBuilderBuildMessageIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#ruleId(Long)}.
   * <p>
   * Method under test: {@link Builder#ruleId(Long)}
   */
  @Test
  @DisplayName("Test Builder ruleId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ruleId(Long)"})
  void testBuilderRuleId() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ruleId(1L));
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
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#vantagePointRank(int)}.
   * <p>
   * Method under test: {@link Builder#vantagePointRank(int)}
   */
  @Test
  @DisplayName("Test Builder vantagePointRank(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.vantagePointRank(int)"})
  void testBuilderVantagePointRank() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePointRank(1));
  }

  /**
   * Test Builder {@link Builder#vantagePoint(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#vantagePoint(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder vantagePoint(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.vantagePoint(EntityReference)"})
  void testBuilderVantagePoint_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePoint(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#classificationCode()}.
   * <p>
   * Method under test: {@link Json#classificationCode()}
   */
  @Test
  @DisplayName("Test Json classificationCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.classificationCode()"})
  void testJsonClassificationCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).classificationCode());
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
   * Test Json {@link Json#dataTypeRank()}.
   * <p>
   * Method under test: {@link Json#dataTypeRank()}
   */
  @Test
  @DisplayName("Test Json dataTypeRank()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.dataTypeRank()"})
  void testJsonDataTypeRank() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeRank());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setClassificationCode(String)}
   *   <li>{@link Json#setDataTypeId(Long)}
   *   <li>{@link Json#setMessage(String)}
   *   <li>{@link Json#setMessageSeverity(MessageSeverity)}
   *   <li>{@link Json#setRuleId(Long)}
   *   <li>{@link Json#setSubjectReference(EntityReference)}
   *   <li>{@link Json#setVantagePoint(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setClassificationCode(String)", "void Json.setDataTypeId(Long)",
      "void Json.setMessage(String)", "void Json.setMessageSeverity(MessageSeverity)", "void Json.setRuleId(Long)",
      "void Json.setSubjectReference(EntityReference)", "void Json.setVantagePoint(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#messageSeverity()}.
   * <p>
   * Method under test: {@link Json#messageSeverity()}
   */
  @Test
  @DisplayName("Test Json messageSeverity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MessageSeverity Json.messageSeverity()"})
  void testJsonMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).messageSeverity());
  }

  /**
   * Test Json {@link Json#ruleId()}.
   * <p>
   * Method under test: {@link Json#ruleId()}
   */
  @Test
  @DisplayName("Test Json ruleId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.ruleId()"})
  void testJsonRuleId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ruleId());
  }

  /**
   * Test Json {@link Json#setDataTypeRank(int)}.
   * <p>
   * Method under test: {@link Json#setDataTypeRank(int)}
   */
  @Test
  @DisplayName("Test Json setDataTypeRank(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeRank(int)"})
  void testJsonSetDataTypeRank() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeRank(1);

    // Assert
    assertEquals(1, json.dataTypeRank);
    assertTrue(json.dataTypeRankIsSet);
  }

  /**
   * Test Json {@link Json#setVantagePointRank(int)}.
   * <p>
   * Method under test: {@link Json#setVantagePointRank(int)}
   */
  @Test
  @DisplayName("Test Json setVantagePointRank(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setVantagePointRank(int)"})
  void testJsonSetVantagePointRank() {
    // Arrange
    Json json = new Json();

    // Act
    json.setVantagePointRank(1);

    // Assert
    assertEquals(1, json.vantagePointRank);
    assertTrue(json.vantagePointRankIsSet);
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

  /**
   * Test Json {@link Json#vantagePoint()}.
   * <p>
   * Method under test: {@link Json#vantagePoint()}
   */
  @Test
  @DisplayName("Test Json vantagePoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.vantagePoint()"})
  void testJsonVantagePoint() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).vantagePoint());
  }

  /**
   * Test Json {@link Json#vantagePointRank()}.
   * <p>
   * Method under test: {@link Json#vantagePointRank()}
   */
  @Test
  @DisplayName("Test Json vantagePointRank()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.vantagePointRank()"})
  void testJsonVantagePointRank() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).vantagePointRank());
  }
}
