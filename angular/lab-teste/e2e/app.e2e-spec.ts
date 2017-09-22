import { LabTestePage } from './app.po';

describe('lab-teste App', () => {
  let page: LabTestePage;

  beforeEach(() => {
    page = new LabTestePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
