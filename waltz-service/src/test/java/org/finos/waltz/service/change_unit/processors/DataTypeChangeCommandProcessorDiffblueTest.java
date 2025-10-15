package org.finos.waltz.service.change_unit.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.data_type.DataTypeDecoratorService;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataTypeChangeCommandProcessorDiffblueTest {
  @InjectMocks private DataTypeChangeCommandProcessor dataTypeChangeCommandProcessor;

  @Mock private DataTypeDecoratorService dataTypeDecoratorService;

  @Mock private PhysicalFlowService physicalFlowService;

  /**
   * Test {@link DataTypeChangeCommandProcessor#supportedAttribute()}.
   *
   * <p>Method under test: {@link DataTypeChangeCommandProcessor#supportedAttribute()}
   */
  @Test
  @DisplayName("Test supportedAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DataTypeChangeCommandProcessor.supportedAttribute()"})
  void testSupportedAttribute() {
    // Arrange, Act and Assert
    assertEquals("DataType", dataTypeChangeCommandProcessor.supportedAttribute());
  }
}
